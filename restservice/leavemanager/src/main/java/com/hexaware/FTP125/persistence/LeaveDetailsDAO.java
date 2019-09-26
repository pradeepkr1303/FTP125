package com.hexaware.FTP125.persistence;

import com.hexaware.FTP125.model.LeaveDetails;
import java.sql.Date;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

/**
 * The DAO class for leaveDetails.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the leaveDetails of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the leavedetails of the selected employee.
   * @param leaveType to initialize the type of leave.
   * @param startDate to initialize start date.
   * @param endDate to initialize end date.
   * @param numOfDays to show number of leave days.
   * @param giveReason to tell the reason for the leave.
   * @param empId to provide employee id.
   * @return the leave detail object
   */
  @SqlUpdate("insert into leave_details (leave_type,start_date,end_date,no_of_days,leave_status,reason,emp_id) values (:LEAVE_TYPE,:START_DATE,:END_DATE,:NUM_OF_DAYS,'PENDING',:REASON,:EMP_ID)")
  int applyLeave(@Bind("LEAVE_TYPE") String leaveType, @Bind("START_DATE")Date startDate,
      @Bind("END_DATE")Date endDate, @Bind("NUM_OF_DAYS")int numOfDays, @Bind("REASON")String giveReason, @Bind("EMP_ID")int empId);

  /**
   * returns the details of leave status.
   * @param emplId the id of the employee.
   * @return the employee leave status.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :emplId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> checkLeavestatus(@Bind("emplId") int emplId);

  /**
   * to provide leave id.
   * @param leaveId the id of the employee.
   * @return the leave details.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails getLeaveDetails(@Bind("leaveId") int leaveId);

  /**
   * return the pending leave of the Employee.
   * @param empID the id of the employee
   * @return the leave balance
   */
  @SqlQuery("select * from leave_details where emp_id in (select emp_id from employee where manager_id = :empID) && leave_status = 'pending'")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> findPendingLeave(@Bind("empID") int empID);

  /** to approve or deny .
   * @param leaveId to initialize leave id
   * @param leaveStatus to initialize the leave status
   * @param managerComments to initialize the manager comments
   * @return the approval status
   */
  @SqlUpdate("update leave_details set leave_status = :LEAVE_STATUS, manager_comments = :MANAGER_COMMENTS where leave_id = :LEAVE_ID")
  int leaveApproval(@Bind("LEAVE_ID") int leaveId, @Bind("LEAVE_STATUS") String leaveStatus, @Bind("MANAGER_COMMENTS") String managerComments);

  /**
  * close with no args is used to close the connection.
  */

  void close();
}
