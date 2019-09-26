package com.hexaware.FTP125.model;
import com.hexaware.FTP125.persistence.LeaveDetailsDAO;
import com.hexaware.FTP125.persistence.DbConnection;

import java.util.Objects;
import java.sql.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

 /**
   * leaveDetails to store leavedetails.
   */
public class LeaveDetails {
  private int leaveId;
  private String leaveType;
  private Date startDate;
  private Date endDate;
  private int noOfDays;
  private String leaveStatus;
  private String reason;
  private String managerComments;
  private int emplId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails leave = (LeaveDetails) obj;
    if (Objects.equals(leaveId, leave.leaveId)
        && Objects.equals(this.leaveType, leave.leaveType)
        && Objects.equals(this.startDate, leave.startDate)
        && Objects.equals(this.endDate, leave.endDate)
        && Objects.equals(this.noOfDays, leave.noOfDays)
        && Objects.equals(this.leaveStatus, leave.leaveStatus)
        && Objects.equals(this.reason, leave.reason)
        && Objects.equals(this.managerComments, leave.managerComments)
        && Objects.equals(this.emplId, leave.emplId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveStatus, reason, managerComments, emplId);
  }
   /**
   * to initialize leavedetails constructor.
   */
  public LeaveDetails() {
    super();
  }

  /**
   * @param argLeaveId to initialize leave Id.
   * @param argLeaveType to initialize leave type.
   * @param argStartDate to initialize starting leave date.
   * @param argEndDate to initialize end date of leave.
   * @param argNoOfDays to initialize no of days leave.
   * @param argLeaveStatus to initialize leavestatus.
   * @param argReason to initialize reason.
   * @param argManagerComments to initialize the manager comments.
   * @param argEmplId to initialize employrr's Id.
   */
  public LeaveDetails(final int argLeaveId, final String argLeaveType, final Date argStartDate, final Date argEndDate,
      final int argNoOfDays, final String argLeaveStatus, final String argReason, final String argManagerComments, final int argEmplId) {
    this.leaveId = argLeaveId;
    this.leaveType = argLeaveType;
    this.startDate = new Date(argStartDate.getTime());
    this.endDate = new Date(argEndDate.getTime());
    this.noOfDays = argNoOfDays;
    this.leaveStatus = argLeaveStatus;
    this.reason = argReason;
    this.managerComments = argManagerComments;
    this.emplId = argEmplId;
  }


  /**
   * Gets the leaveId.
   * @return this leaveId.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * to set the leaveId.
   * @param argLeaveId to set leaveId.
   */
  public final void setleaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
  /**
   * Gets the leavetype.
   * @return this leavetype.
   */
  public final String getLeaveType() {
    return leaveType;
  }

  /**
   * to set the leavetype.
   * @param argLeaveType to set leaveType.
   */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = argLeaveType;
  }
  /**
   * Gets the startdate.
   * @return this startdate.
   */
  public final Date getStartDate() {
    Date tempDate = startDate;
    return tempDate;
  }

  /**
   * to set the startdate.
   * @param argStartDate to set startdate.
   */
  public final void setStartDate(final Date argStartDate) {
    this.startDate = new Date(argStartDate.getTime());
  }
  /**
   * Gets the enddate.
   * @return this enddate.
   */
  public final Date getEndDate() {
    Date tempDate = endDate;
    return tempDate;
  }

  /**
   * to set the enddate.
   * @param argEndDate to set enddate.
   */
  public final void setEndDate(final Date argEndDate) {
    this.endDate = new Date(argEndDate.getTime());
  }
  /**
   * Gets the nooofDays.
   * @return this noofDays.
   */
  public final int getNoOfDays() {
    return noOfDays;
  }

  /**
   * to set the noOfDays.
   * @param argNoOfDays to set noOfDays.
   */
  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }
  /**
   * Gets the leavestatus.
   * @return this leavestatus.
   */
  public final String getLeaveStatus() {
    return leaveStatus;
  }

  /**
   * to set the leavestatus.
   * @param argLeaveStatus to set leavestatus.
   */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
  /**
   * Gets the reason.
   * @return this reason.
   */
  public final String getReason() {
    return reason;
  }

  /**
   * to set the reason.
   * @param argReason to set reason.
   */
  public final void setReason(final String argReason) {
    this.reason = argReason;
  }
  /**
   * Gets the managerComments.
   * @return this managerComments.
   */
  public final String getManagerComments() {
    return managerComments;
  }

  /**
   * to set the managerComments.
   * @param argManagerComments to set managerComments.
   */
  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
  }
  /**
   * Gets the empId.
   * @return this empId.
   */
  public final int getEmplId() {
    return emplId;
  }

  /**
   * to set the empId.
   * @param argEmplId to set empId.
   */
  public final void setEmplId(final int argEmplId) {
    this.emplId = argEmplId;
  }

  @Override
  /**
   * to convert object properties into string.
   */
   public final String toString() {
    return "Emp id = " + emplId + " Leave type = " + leaveType + " Start date = " + startDate + " End date = " + endDate
      + " No of days = " + noOfDays + " Leave status = " + leaveStatus + " reason = " + reason + " Manager comments = " + managerComments;
  }

  /**
   * the dao for leaveDetails.
   * @return db.
   */
  public static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

      /**
   * To view the leave balance.
   * @param empID to pass leave details to view pendingleave method.
   * @return int
   */
  public static LeaveDetails[] viewPendingLeaves(final int empID) {
    List<LeaveDetails> ld = dao().findPendingLeave(empID);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }

  /**
   * To approve or deny leave.
   * @param ld to pass leave details to approve or denied method.
   * @return int
   */
  public static int approvedOrDenied(final LeaveDetails ld) {
    return dao().leaveApproval(ld.leaveId, ld.leaveStatus, ld.managerComments);
  }

  /**
   * To apply leave.
   * @param ld to pass leave details to applyLeave method.
   * @param emp to pass leave balance to applyLeave method.
   * @return int
   */
  public static int applyLeave(final LeaveDetails ld, final Employee emp) {
    int leaveApplied =  dao().applyLeave(ld.leaveType, ld.startDate, ld.endDate, ld.noOfDays, ld.reason, ld.emplId);
    if (leaveApplied != 0) {
      int updatedLeaveBalance = emp.getEmpLeaveBalance() - ld.getNoOfDays();
      int leaveBalanceUpdated = Employee.updateLeave(ld.getEmplId(), updatedLeaveBalance);
      if (leaveBalanceUpdated != 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }

  /**
   * TO check leave status.
   * to call leave details to check the leave status.
   * @param emplId to initialize employeeid.
   * @return LeaveDetails.
   */
  public static LeaveDetails[] lStatus(final int emplId) {
    List<LeaveDetails> status = dao().checkLeavestatus(emplId);
    return status.toArray(new LeaveDetails[status.size()]);
  }

  /**
   * Parse a string to sql date.
   * @param strDate to initialize employeeid.
   * @return Date.
   */
  public static Date toSqlDate(final String strDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date sqlDate = new Date(System.currentTimeMillis());
    try {
      java.util.Date date = dateFormat.parse(strDate);
      sqlDate = new Date(date.getTime());
      return sqlDate;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sqlDate;
  }

  /**
   * To calculate no of working days between two dates.
   * @param startDate is start date.
   * @param endDate is end date.
   * @return int.
   */
  public static int daysBetween(final String startDate, final String endDate) {
    int days = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    try {
      Calendar start = Calendar.getInstance();
      start.setTime(sdf.parse(startDate));
      Calendar end = Calendar.getInstance();
      end.setTime(sdf.parse(endDate));
      int workingDays = 0;
      while (!start.after(end)) {
        int day = start.get(Calendar.DAY_OF_WEEK);
        if (day != Calendar.SATURDAY && day != Calendar.SUNDAY) {
          workingDays++;
        }
        start.add(Calendar.DATE, 1);
      }
      days = workingDays;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return days;
  }

  /**
   * To find whether given date is past date or not.
   * @param startDate is the date to check whether past or not.
   * @return int.
   */
  public static boolean isNotPast(final String startDate) {
    java.util.Date uStartDate = new java.util.Date();
    java.util.Date uCurrentDate =  new java.util.Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String date = simpleDateFormat.format(new java.util.Date());
    try {
      uCurrentDate = simpleDateFormat.parse(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      uStartDate = simpleDateFormat.parse(startDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Boolean isBefore = uStartDate.before(uCurrentDate);
    return !isBefore;
  }

  /**
   * To find whether given date is past date or not.
   * @param givenDate is given date.
   * @param startDate is start date of leave.
   * @return int.
   */
  public static boolean isNotPast(final String givenDate, final String startDate) {
    java.util.Date uGivenDate = new java.util.Date();
    java.util.Date uStartDate = new java.util.Date();
    java.util.Date uCurrentDate =  new java.util.Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String date = simpleDateFormat.format(new java.util.Date());

    try {
      uGivenDate = simpleDateFormat.parse(givenDate);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      uStartDate = simpleDateFormat.parse(startDate);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      uCurrentDate = simpleDateFormat.parse(date);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Boolean isBefore = !uGivenDate.before(uCurrentDate) && !uGivenDate.before(uStartDate);
    return isBefore;
  }

  /**
   * To check the date as valid or not.
   * @param date for passing string date.
   * @return true or false
   */

  public static boolean isValid(final String date) {
    String[] ymd = date.split("-");
    boolean result;
    int day = Integer.parseInt(ymd[0]);
    int month = Integer.parseInt(ymd[1]);
    int year = Integer.parseInt(ymd[2]);
    Calendar mycal = new GregorianCalendar(year, month, day);
    int maxDays = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
    if (month <= 12 && day <= maxDays) {
      result = true;
    } else {
      result = false;
    }
    return result;
  }

  /**
   * To update the status.
   * @param ld to pass leave details object
   * @return approved or not.
   */
  public static int updateStatus(final LeaveDetails ld) {
    return dao().leaveApproval(ld.getLeaveId(), ld.getLeaveStatus(), ld.getManagerComments());
  }

  /**
   * To get leave details by leaveId.
   * @param leaveId to update status of leave in leavedetails table.
   * @return LeaveDetails.
   */
  public static LeaveDetails getLeaveDetailsByLeaveId(final int leaveId) {
    return dao().getLeaveDetails(leaveId);
  }

}
