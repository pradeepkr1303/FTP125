package com.hexaware.FTP125.util;
import java.util.Scanner;

import com.hexaware.FTP125.model.Employee;
import com.hexaware.FTP125.model.LeaveDetails;
import com.hexaware.FTP125.model.LeaveTypes;
import com.hexaware.FTP125.model.LeaveStatus;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Manager Details");
    System.out.println("4. Apply Leave");
    System.out.println("5. Check Leave status");
    System.out.println("6. View pending Leaves");
    System.out.println("7. Approve or deny");
    System.out.println("8. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        managerDetails();
        break;
      case 4:
        applyForLeave();
        break;
      case 5:
        checkLeaveStatus();
        break;
      case 6:
        viewPendingLeaves();
        break;
      case 7:
        leaveApproval();
        break;
      case 8:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Enter number between 1-8");
    }
    mainMenu();
  }

  /**
   * to list all details of employees.
   */
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.println("");
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    System.out.println("| Emp_Id | Emp_Name        | Emp_Email                      | Emp_PhNo    | Dept_No | leave_balance | Manager_id |");
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    for (Employee e : employee) {
      System.out.printf("| %-6d | %-15s | %-30s | %-11d | %-7d | %-13d | %-10d |%n", e.getEmpId(), e.getEmpName(), e.getEmpEmail(), e.getEmpPhoneNo(),
          e.getEmpDeptNo(), e.getEmpLeaveBalance(), e.getEmpManagerId());
    }
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    System.out.println("");
  }

  /**
   * to display the employee detail by emp_id.
   */
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      displayAsTableEmployee(employee);
    }
  }

  /**
   * to display manager_id using emp_id.
   */
  private void managerDetails() {
    System.out.println();
    System.out.println("Enter employee ID : ");
    int tempEmpId = option.nextInt();
    Employee employee = Employee.displayManagerDetails(tempEmpId);
    if (employee == null) {
      System.out.println("Sorry, you dont have manager or result may be empty");
    } else {
      displayAsTableEmployee(employee);
    }
  }

  /**
   * to apply leave.
   */
  private void applyForLeave() {
    String stringDateStart;
    String stringDateEnd;
    LeaveDetails ld = new LeaveDetails();
    int choice;
    java.sql.Date startDate;
    java.sql.Date endDate;
    int flag = 0;
    int numOfDays = 0;
    System.out.println("Employee id :");
    int empId = option.nextInt();
    ld.setEmplId(empId);
    Employee emp = Employee.listById(empId);
    if (emp.isEmpValid(empId)) {
      System.out.println("Leave balance = " + emp.getEmpLeaveBalance());
      do {
        System.out.println("Enter option for Leave Type : 1.EL 2.LOP 3.SICK_LEAVE");
        choice = option.nextInt();
        switch (choice) {
          case 1: ld.setLeaveType(LeaveTypes.EL.name());
          break;
          case 2: ld.setLeaveType(LeaveTypes.LOP.name());
          break;
          case 3: ld.setLeaveType(LeaveTypes.SICK_LEAVE.name());
          break;
          default : System.out.println("Enter number between 1-3 : ");
        }
      } while (choice < 1 || choice > 3);
      try {
        do {
          System.out.println("Enter the start date (dd-MM-yyyy) :");
          stringDateStart = option.next();
          startDate = LeaveDetails.toSqlDate(stringDateStart);
          if (LeaveDetails.isValid(stringDateStart)) {
            if (LeaveDetails.isNotPast(stringDateStart)) {
              ld.setStartDate(startDate);
              flag = 1;
            } else {
              System.out.println("Don't enter Past date");
            }
          } else {
            System.out.println("Enter the valid date");
          }
        } while (flag < 1);

        do {
          System.out.println("Enter the end date (dd-MM-yyyy) :");
          stringDateEnd = option.next();
          endDate = LeaveDetails.toSqlDate(stringDateEnd);
          if (LeaveDetails.isValid(stringDateEnd)) {
            if (LeaveDetails.isNotPast(stringDateEnd, stringDateStart)) {
              ld.setEndDate(endDate);
              flag = 2;
            } else {
              System.out.println("Don't enter the past date of current date or start date!");
            }
          }
        } while (flag < 2);
        numOfDays = LeaveDetails.daysBetween(stringDateStart, stringDateEnd);
        System.out.println("Number of Days = " + numOfDays);
        ld.setNoOfDays(numOfDays);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Give the valid date format");
      }
      System.out.println("Give Reason");
      option.nextLine();
      String giveReason = option.nextLine();
      ld.setReason(giveReason);
      int leaveApplied = LeaveDetails.applyLeave(ld, emp);
      if (leaveApplied == 1) {
        System.out.println("leave Applied");
      } else {
        System.out.println("leave not Applied");
      }
    } else {
      System.out.println("No such employee id found");
    }
  }


  /**
   * to check leave status of a employee.
   */
  private void checkLeaveStatus() {
    System.out.println("Enter the Employee ID for the person : ");
    int emplId = option.nextInt();
    LeaveDetails[] ld = LeaveDetails.lStatus(emplId);
    //System.out.println("Leave details");
    if (ld == null) {
      System.out.println("INVALID EMPLOYEE ID");
    } else {
      System.out.println("%n");
      System.out.println("+------------+--------------+----------------+----------------+------------------+");
      System.out.println("|   Emp_Id   |   Leave_Id   |   Leave_Type   |   No_Of_Days   |   Leave_Status   |");
      System.out.println("+------------+--------------+----------------+----------------+------------------+");
      for (LeaveDetails l : ld) {
        System.out.printf("| %-12d | %-14d | %-16s | %-16d | %-18s |%n", l.getEmplId(), l.getLeaveId(), l.getLeaveType(), l.getNoOfDays(), l.getLeaveStatus());        // System.out.println("Employee Id " + l.getEmplId());
        // System.out.println("Leave Id " + l.getLeaveId());
        // System.out.println("LeaveType " + l.getLeaveType());
        // System.out.println("NoOfDays " + l.getNoOfDays());
        // System.out.println("LeaveStatus " + l.getLeaveStatus());
      }
      System.out.println("+------------+--------------+----------------+----------------+------------------+");
    }
  }

  /**
   * to view pending leaves.
   */
  private void viewPendingLeaves() {
    System.out.println("Enter your Employee Id: ");
    int empId = option.nextInt();
    LeaveDetails[] ld = LeaveDetails.viewPendingLeaves(empId);
    displayAsTableLeaves(ld);
  }

  /**
   * to approve or deny the leave.
   */
  private void leaveApproval() {
    System.out.println("Enter your Employee Id: ");
    int empId = option.nextInt();
    LeaveDetails[] ld = LeaveDetails.viewPendingLeaves(empId);
    displayAsTableLeaves(ld);
    System.out.println("Enter the LEAVE_ID you want to approve/deny:");
    int leaveId = option.nextInt();
    String approval;
    for (LeaveDetails levDet : ld) {
      if (leaveId == levDet.getLeaveId()) {
        levDet.setleaveId(leaveId);
        String managerComments = "";
        System.out.println("Enter 1.Approve 2.Deny");
        int a = option.nextInt();
        if (a == 1) {
          approval = LeaveStatus.APPROVED.name();
          levDet.setLeaveStatus(approval);
          int updatedRows = LeaveDetails.updateStatus(levDet);
          System.out.println("Leave approved and " + updatedRows + " rows updated.");
        } else {
          approval = LeaveStatus.DENIED.name();
          levDet.setLeaveStatus(approval);
          System.out.println("Reason : ");
          option.nextLine();
          managerComments = option.nextLine();
          int updatedRows = LeaveDetails.updateStatus(levDet);
          System.out.println("Leave approved and " + updatedRows + " rows updated.");
          System.out.println("Leave Denied.");
          System.out.println("Reason = " + managerComments);
          Employee emp = Employee.listEmpDetailsByLeaveId(leaveId);
          levDet = LeaveDetails.getLeaveDetailsByLeaveId(leaveId);
          int updatedLeaveBalance = emp.getEmpLeaveBalance() + levDet.getNoOfDays();
          int rowInserted = Employee.updateLeave(levDet.getEmplId(), updatedLeaveBalance);
          System.out.println(rowInserted + " row updated");
          System.out.println("Updated leave balance = " + updatedLeaveBalance);
        }
        levDet.setLeaveStatus(approval);
        levDet.setManagerComments(managerComments);
      } else {
        System.out.println("Enter the leave id of the respective employee");
      }
    }
  }

  /**
   * to display as a table.
   * @param ld to pass the objects.
   */
  public final void displayAsTableLeaves(final LeaveDetails[] ld) {
    System.out.println("+----------+------------+------------+----------+------------+--------------+--------+--------+------------------+");
    System.out.println("| Leave_Id | Leave_Type | Start_Date | End_Date | No_Of_days | Leave_Status | Emp_Id | Reason | Manager_Comments |");
    System.out.println("+----------+------------+------------+----------+------------+--------------+--------+--------+------------------+");
    for (LeaveDetails l : ld) {
      System.out.printf("|%-10d|%-12s|%-12s|%-10s|%-12d|%-14s|%-8d|%-8s|%-18s|%n", l.getLeaveId(), l.getLeaveType(), l.getStartDate(), l.getEndDate(), l.getNoOfDays(), l.getLeaveStatus(), l.getEmplId(), l.getReason(), l.getManagerComments());
    }
    System.out.println("+----------+------------+------------+----------+------------+--------------+--------+--------+------------------+");
  }

  /**
   * Display pattern for Employee details.
   * @param employee to get Employee details.
   */
  public final void displayAsTableEmployee(final Employee employee) {
    System.out.println("");
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    System.out.println("| Emp_Id | Emp_Name        | Emp_Email                      | Emp_PhNo    | Dept_No | leave_balance | Manager_id |");
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    System.out.printf("| %-6d | %-15s | %-30s | %-11d | %-7d | %-13d | %-10d |%n", employee.getEmpId(), employee.getEmpName(), employee.getEmpEmail(),
        employee.getEmpPhoneNo(), employee.getEmpDeptNo(), employee.getEmpLeaveBalance(), employee.getEmpManagerId());
    System.out.println("+--------+-----------------+--------------------------------+-------------+---------+---------------+------------+");
    System.out.println("");
  }

  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
  /**
   * this method id ued for testing purpose.
   */
  public final void testMethod() {
    System.out.println("testMethod() called");
  }
}
