package com.hexaware.FTP125.model;

import com.hexaware.FTP125.persistence.DbConnection;
import com.hexaware.FTP125.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private long empPhoneNo;
  private String empEmail;
  private int deptNo;
  private int empLeaveBalance;
  private int managerId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(this.empName, emp.empName)
        && Objects.equals(this.empPhoneNo, emp.empPhoneNo)
        && Objects.equals(this.empEmail, emp.empEmail)
        && Objects.equals(this.deptNo, emp.deptNo)
        && Objects.equals(this.empLeaveBalance, emp.empLeaveBalance)
        && Objects.equals(this.managerId, emp.managerId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empPhoneNo, empEmail, deptNo, empLeaveBalance, managerId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * to initialize employee constructor.
   */
  public Employee() {
    super();
  }

  /**
   * @param argempId to initialize employee id.
   * @param argempName to initialize employee name.
   * @param argempPhoneNo to initialize employee phone number.
   * @param argempEmail to initialize employee email.
   * @param argdeptNo to initialize employee's department number.
   * @param argempLeaveBalance to initialize employee's leave balance.
   * @param argmanagerId to initialize employee's manager ID.
   */
  public Employee(final int argempId, final String argempName, final long argempPhoneNo, final String argempEmail,
      final int argdeptNo, final int argempLeaveBalance, final int argmanagerId) {
    this.empId = argempId;
    this.empName = argempName;
    this.empPhoneNo = argempPhoneNo;
    this.empEmail = argempEmail;
    this.deptNo = argdeptNo;
    this.empLeaveBalance = argempLeaveBalance;
    this.managerId = argmanagerId;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * to set the employee id.
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {
    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * list employee details by id.
   * @param leaveId id to get employee details.
   * @return Employee
   */
  public static Employee listEmpDetailsByLeaveId(final int leaveId) {
    return dao().listByLeaveId(leaveId);
  }

  /**
   * update leaveBalance.
   * @param empID id to update leaveBalance.
   * @param remainingLeave id to update leaveBalance.
   * @return int
   */
  public static int updateLeave(final int empID, final int remainingLeave) {
    return dao().updateLeaveBalance(empID, remainingLeave);
  }

  /**
   * list manager details by using employee id.
   * @param empID id to get manager details.
   * @return Employee
   */
  public static Employee displayManagerDetails(final int empID) {
    return dao().findManager(empID);
  }

  /**
   * Gets the Employee name.
   * @return this Employee's name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   * to set the employee name.
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   * Gets the Employee E-mail.
   * @return this Employee's E-mail.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   * to set the employee E-mail.
   * @param argEmpEmail to set employee E-mail.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   * Gets the Employee phone number.
   * @return this Employee's phone number.
   */
  public final long getEmpPhoneNo() {
    return empPhoneNo;
  }

  /**
   * to set the employee phone number.
   * @param argEmpPhoneNo to set employee phone number.
   */
  public final void setEmpPhoneNo(final long argEmpPhoneNo) {
    this.empPhoneNo = argEmpPhoneNo;
  }

  /**
   * Gets the Employee department number.
   * @return this Employee's department number.
   */
  public final int getEmpDeptNo() {
    return deptNo;
  }

  /**
   * to set the employee department number.
   * @param argEmpDeptNo to set employee department number.
   */
  public final void setEmpDeptNo(final int argEmpDeptNo) {
    this.deptNo = argEmpDeptNo;
  }

  /**
   * Gets the Employee leave balance.
   * @return this Employee's leave balance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   * to set the employee leave balance.
   * @param argEmpLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * Gets the Employee manager id.
   * @return this Employee's manager id.
   */
  public final int getEmpManagerId() {
    return managerId;
  }

  /**
   * To return employee is valid or not.
   * @param argEmpId to pass the employee id
   * @return is valid or not
   */
  public final boolean isEmpValid(final int argEmpId) {
    Employee[] employees = listAll();
    boolean empValid = false;
    for (Employee emp : employees) {
      if (argEmpId == emp.getEmpId()) {
        empValid = true;
      }
    }
    return empValid;
  }

  /**
   * to set the employee manager id.
   * @param argEmpManagerId to set employee manager id.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.managerId = argEmpManagerId;
  }
    /**
   * to set the string.
   * @return this to set the string
   */
  public final String toString() {
    return "empId = " + empId + "empName = " + empName + "empPhoneNo = " + empPhoneNo + "empEmail = " + empEmail
      + "empDeptNo = " + deptNo + "empLeaveBalance = " + empLeaveBalance + "empManagerId = " + managerId;
  }
}
