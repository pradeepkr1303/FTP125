package com.hexaware.FTP125.persistence;

import com.hexaware.FTP125.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * return the details of the selected employee's manager.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = (SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_ID = :empID)")
  @Mapper(EmployeeMapper.class)
  Employee findManager(@Bind("empID") int empID);

  /**
   * Update the leaveBalance in employee table.
   * @param empId the id of the employee.
   * @param remainingLeave for updating leaveBalance.
   * @return int.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET LEAVE_BALANCE = :leaveBalance WHERE EMP_ID = :empID")
  int updateLeaveBalance(@Bind("empID") int empId, @Bind("leaveBalance") int remainingLeave);

  /**
   * return all the details of the selected employee by using leaveId.
   * @param leaveId the id of the employee
   * @return the employee object
   */
  @SqlQuery("select * from employee where emp_id = (select emp_id from leave_details where leave_id = :leaveId)")
  @Mapper(EmployeeMapper.class)
  Employee listByLeaveId(@Bind("leaveId") int leaveId);

  /**
  * close with no args is used to close the connection.
  */
  void close();
}
