package com.hexaware.FTP125.util;

import javax.ws.rs.GET;
// import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hexaware.FTP125.model.Employee;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = Employee.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response employeeListById(@PathParam("id") final int id) {
    final Employee empl = Employee.listById(id);
    if (empl != null) {
      return Response.status(200).entity(empl).build();
    } else {
      ErrorCode err = new ErrorCode("Sorry Employee id " + id + " not found", 404);
      return Response.status(404).entity(err).build();
    }
  }

   /**
   * Returns a specific employee's details.
   * @param empId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/manager/{manager_id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response employeeDetails(@PathParam("manager_id") final int empId) {
    final Employee empl = Employee.displayManagerDetails(empId);
    if (empl != null) {
      return Response.status(200).entity(empl).build();
    } else {
      ErrorCode err = new ErrorCode("Sorry " + empId + " not found", 404);
      return Response.status(404).entity(err).build();
    }
  }
}

