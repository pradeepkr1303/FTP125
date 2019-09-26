package com.hexaware.FTP125.util;


import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
// import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hexaware.FTP125.model.Employee;
import com.hexaware.FTP125.model.LeaveDetails;


/**
 * This class provides a REST interface for the employee entity.
 * This class provides a REST interface for the leavedetails entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {
  /**
   * Returns a list of all the leaves status of the employee.
   * @param employeeId for passing the id of the employee.
   * @return a list of all the leaveDetais.
   */
  @GET
  @Path("/GetLeaveStatus/{emp_id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response leaveStatus(@PathParam("emp_id") final int employeeId) {
    System.out.println("Leave details list");
    final LeaveDetails[] leaveDetails = LeaveDetails.lStatus(employeeId);
    if (leaveDetails.length == 0) {
      ErrorCode errorCode = new ErrorCode("Sorry there is no record Found", 404);
      return Response.status(404).entity(errorCode).build();
    } else {
      return Response.status(200).entity(leaveDetails).build();
    }
  }

  /**
   * To apply a leave.
   * @param leaveDetails To apply a leave.
   * @return response.
   */
  @POST
  @Path("/ApplyLeave")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final Response applyLeave(final LeaveDetails leaveDetails) {
    if (leaveDetails.getEmplId() != 1000) {
      Employee emp = new Employee();
      if (emp.isEmpValid(leaveDetails.getEmplId())) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date startDate = new java.util.Date(leaveDetails.getStartDate().getTime());
        java.util.Date endDate = new java.util.Date(leaveDetails.getEndDate().getTime());
        String stringStart = sdf.format(startDate);
        String stringEnd = sdf.format(endDate);
        leaveDetails.setNoOfDays(leaveDetails.daysBetween(stringStart, stringEnd));
        int rowsUpdated = leaveDetails.applyLeave(leaveDetails, emp);
        if (LeaveDetails.isNotPast(stringStart) && LeaveDetails.isNotPast(stringEnd)) {
          if (rowsUpdated == 0) {
            ErrorCode error = new ErrorCode("Leave not applied.", 404);
            return Response.status(404).entity(error).build();
          } else {
            ErrorCode error = new ErrorCode("Leave applied.", 200);
            return Response.status(200).entity(error).build();
          }
        } else {
          ErrorCode error = new ErrorCode("Don't Enter the past date", 406);
          return Response.status(406).entity(error).build();
        }
      } else {
        ErrorCode error = new ErrorCode("No such employee found", 406);
        return Response.status(406).entity(error).build();
      }
    } else {
      ErrorCode error = new ErrorCode("CEO cannot apply.", 406);
      return Response.status(406).entity(error).build();
    }
  }


  /**
   * Returns a list of all the pending leaves.
   * @param empId to get the pending leaves.
   * @return a list of all the pending leaves.
   */
  @GET
  @Path("/findPendingLeave/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listViewPendingLeaves(@PathParam("empId") final int empId) {
    final LeaveDetails[] leaveDetail = LeaveDetails.viewPendingLeaves(empId);
    if (leaveDetail.length != 0) {
      return Response.status(200).entity(leaveDetail).build();
    } else {
      ErrorCode err = new ErrorCode("Sorry " + empId + " is not a Manager", 404);
      return Response.status(404).entity(err).build();
    }
  }
  /**
   * return approve or deny.
   * @param leaveDetails to pass
   * @return approval status
   */
  @PUT
  @Path("/approveOrDeny")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response approveOrDeny(final LeaveDetails leaveDetails) {
    int rowsUpdated = LeaveDetails.approvedOrDenied(leaveDetails);
    if (rowsUpdated == 0) {
      ErrorCode errorCode = new ErrorCode("Leave not found", 404);
      return Response.status(404).entity(errorCode).build();
    } else {
      String stat = leaveDetails.getLeaveStatus();
      if (stat.equals("APPROVED")) {
        ErrorCode errorCode = new ErrorCode("Leave approved", 200);
        return Response.status(200).entity(errorCode).build();
      } else {
        ErrorCode errorCode = new ErrorCode("Leave denied", 200);
        return Response.status(200).entity(errorCode).build();
      }
    }
  }
}
