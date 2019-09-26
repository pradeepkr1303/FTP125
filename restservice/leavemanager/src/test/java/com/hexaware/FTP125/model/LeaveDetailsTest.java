package com.hexaware.FTP125.model;


import com.hexaware.FTP125.persistence.LeaveDetailsDAO;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
// import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

//import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Test that checks the constructor of leaveDetails class for its value assignment.
   */
  @Test
  public final void testLeaveDetailsConstructor() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertEquals(1, tempLeaveDetails.getLeaveId());
    assertEquals("EL", tempLeaveDetails.getLeaveType());
    assertEquals(tempDateStart, tempLeaveDetails.getStartDate());
    assertEquals(tempDateEnd, tempLeaveDetails.getEndDate());
    assertEquals(2, tempLeaveDetails.getNoOfDays());
    assertEquals("PENDING", tempLeaveDetails.getLeaveStatus());
    assertEquals("SPECIFIC", tempLeaveDetails.getReason());
    assertEquals("MANAGER SPECIFIC", tempLeaveDetails.getManagerComments());
    assertEquals(2000, tempLeaveDetails.getEmplId());
  }

  /**
   * Test that checks the constructor of leaveDetails class for its value assignment.
   */
  @Test
  public final void testNotEqualsLeaveDetailsConstructor() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertNotEquals(2, tempLeaveDetails.getLeaveId());
    assertNotEquals("LOP", tempLeaveDetails.getLeaveType());
    assertNotEquals(tempDateEnd, tempLeaveDetails.getStartDate());
    assertNotEquals(tempDateStart, tempLeaveDetails.getEndDate());
    assertNotEquals(3, tempLeaveDetails.getNoOfDays());
    assertNotEquals("APPROVED", tempLeaveDetails.getLeaveStatus());
    assertNotEquals("NO REASON", tempLeaveDetails.getReason());
    assertNotEquals("NO REASON", tempLeaveDetails.getManagerComments());
    assertNotEquals(1000, tempLeaveDetails.getEmplId());
  }

  /**
   * To test the getter and setter of leave id.
   */
  @Test
  public final void testValidSetLeaveId() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setleaveId(1000);
    assertEquals(1000, leaveDetails.getLeaveId());
  }

  /**
   * To test the invalid getter and setter leave id.
   */

  @Test
  public final void testNotValidSetLeaveId() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setleaveId(1000);
    assertNotEquals(1001, leaveDetails.getLeaveId());
  }

  /**
   * To test the getter and setter leave Type.
   */
  @Test
  public final void testValidSetLeaveType() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setLeaveType("EL");
    assertEquals("EL", leaveDetails.getLeaveType());
  }

  /**
   * To test the getter and setter of start date.
   */

  @Test
  public final void testValidSetStartDate() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String stringStartDate = "19-02-2019";
    java.sql.Date startDate = LeaveDetails.toSqlDate(stringStartDate);
    leaveDetails.setStartDate(startDate);
    assertEquals(startDate, leaveDetails.getStartDate());
  }

    /**
   * To test the getter and setter of start date.
   */

  @Test
  public final void testNotValidSetStartDate() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String stringStartDate = "19-02-2019";
    String stringStartDate1 = "18-02-2019";
    java.sql.Date startDate = LeaveDetails.toSqlDate(stringStartDate);
    java.sql.Date startDate1 = LeaveDetails.toSqlDate(stringStartDate1);
    leaveDetails.setStartDate(startDate);
    assertNotEquals(startDate1, leaveDetails.getStartDate());
  }


  /**
   * To test the getter and setter of start date.
   */

  @Test
  public final void testValidSetEndDate() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String stringEndDate = "19-02-2019";
    java.sql.Date endDate = LeaveDetails.toSqlDate(stringEndDate);
    leaveDetails.setEndDate(endDate);
    assertEquals(endDate, leaveDetails.getEndDate());
  }


    /**
   * To test the getter and setter of start date.
   */

  @Test
  public final void testNotValidSetEndDate() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String stringEndDate = "19-02-2019";
    String stringEndDate1 = "18-02-2019";
    java.sql.Date endDate = LeaveDetails.toSqlDate(stringEndDate);
    java.sql.Date endDate1 = LeaveDetails.toSqlDate(stringEndDate1);
    leaveDetails.setEndDate(endDate);
    assertNotEquals(endDate1, leaveDetails.getEndDate());
  }

  /**
   * To test the invalid getter and setter leave type.
   */

  @Test
  public final void testNotValidSetLeaveType() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setLeaveType("LOP");
    assertNotEquals("SICK_LEAVE", leaveDetails.getLeaveType());
  }

    /**
   * To test the getter and setter of no of days.
   */
  @Test
  public final void testValidNoOfDays() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setNoOfDays(12);
    assertEquals(12, leaveDetails.getNoOfDays());
  }

  /**
   * To test the invalid getter and setter of no of days.
   */

  @Test
  public final void testNotValidNoOfDays() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setNoOfDays(12);
    assertNotEquals(10, leaveDetails.getNoOfDays());
  }

  /**
   * To test the getter and setter of leave status.
   */
  @Test
  public final void testValidLeaveStatus() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setLeaveStatus("PENDING");
    assertEquals("PENDING", leaveDetails.getLeaveStatus());
  }

  /**
   * To test the invalid getter and setter of leave status.
   */

  @Test
  public final void testNotValidLeaveStatus() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setLeaveStatus("PENDING");
    assertNotEquals("APPROVAL", leaveDetails.getLeaveStatus());
  }

  /**
   * To test the getter and setter of reason.
   */
  @Test

  public final void testValidReason() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setReason("nonononono");
    assertEquals("nonononono", leaveDetails.getReason());
  }

  /**
   * To test invalid the getter and setter of reason.
   */
  @Test
  public final void testNotValidReason() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setReason("nonononono");
    assertNotEquals("yesyesyes", leaveDetails.getReason());
  }

  /**
   * To test the getter and setter of manager comments.
   */
  @Test

  public final void testValidManagerComments() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setManagerComments("nonononono");
    assertEquals("nonononono", leaveDetails.getManagerComments());
  }

  /**
   * To test invalid the getter and setter of manager comments.
   */
  @Test
  public final void testNotValidManagerComments() {
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setManagerComments("nonononono");
    assertNotEquals("yesyesyes", leaveDetails.getManagerComments());
  }

  /**
   * Tests the tostring methods of the LeaveDetails class.
   */
  @Test
  public final void testToString() {
    java.sql.Date tempStartDate = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempEndDate = new java.sql.Date(2019, 03, 06);
    LeaveDetails leavedetails = new LeaveDetails(1, "EL", tempStartDate, tempEndDate, 4, "Pending", "fever", "okGranted", 2000);
    LeaveDetails leavedetails1 = new LeaveDetails(1, "EL", tempStartDate, tempEndDate, 4, "Pending", "fever", "okGranted", 2000);
    assertEquals(leavedetails.toString(), leavedetails1.toString());
  }

  /**
   * Tests the  notequals tostring methods of the LeaveDetails class.
   */
  @Test
  public final void testInvalidToString() {
    java.sql.Date tempStartDate = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempEndDate = new java.sql.Date(2019, 03, 06);
    LeaveDetails leavedetails = new LeaveDetails(1, "EL", tempStartDate, tempEndDate, 4, "Pending", "fever", "okGranted", 2000);
    LeaveDetails leavedetails1 = new LeaveDetails(2, "LOP", tempStartDate, tempEndDate, 4, "Pending", "fever", "okGranted", 2000);
    assertNotEquals(leavedetails.toString(), leavedetails1.toString());
  }

  /**
   * To check isNotPast() method.
   */
  @Test
  public final void testIsNotPast() {
    Boolean result = LeaveDetails.isNotPast("31-12-2029");
    assertEquals(true, LeaveDetails.isNotPast("31-12-2029"));
  }

  /**
   * To check isNotPast() method.
   */
  @Test
  public final void testNotIsNotPast() {
    Boolean result = LeaveDetails.isNotPast("31-12-2029");
    assertNotEquals(false, LeaveDetails.isNotPast("31-12-2029"));
  }

  /**
   * To check toSqlDate() method.
   */
  @Test
  public final void testToSqlDate() {
    java.util.Date tempUtilDate = new java.util.Date(97, 02, 13);
    java.sql.Date tempSqlDate = new java.sql.Date(tempUtilDate.getTime());
    assertEquals(tempSqlDate, LeaveDetails.toSqlDate("13-03-1997"));
  }

  /**
   * To check toSqlDate() method.
   */
  @Test
  public final void testNotToSqlDate() {
    java.util.Date tempUtilDate = new java.util.Date(97, 02, 13);
    java.sql.Date tempSqlDate = new java.sql.Date(tempUtilDate.getTime());
    java.util.Date tempUtilDate1 = new java.util.Date(98, 02, 13);
    java.sql.Date tempSqlDate1 = new java.sql.Date(tempUtilDate1.getTime());
    assertEquals(tempSqlDate, LeaveDetails.toSqlDate("13-03-1997"));
  }

  /**
   * To test updateStatus in LeaveDetails.java .
   * @param dao to Mock LeaveDetailsDAO.java .
   */
  @Test
  public final void testUpdateStatus(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setleaveId(1);
    leaveDetails.setLeaveStatus("APPROVED");
    leaveDetails.setManagerComments("Avoid taking leaves like this.");
    new Expectations() {
      {
        dao.leaveApproval(leaveDetails.getLeaveId(), leaveDetails.getLeaveStatus(), leaveDetails.getManagerComments());
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int updatedRows = LeaveDetails.updateStatus(leaveDetails);
    assertNotNull(updatedRows);
  }

  /**
   * to test daysBetween() method.
   */

  @Test
   public final void testDaysBetween() {
    int result = LeaveDetails.daysBetween("05-03-2019", "08-03-2019");
    assertEquals(4, result);
  }

  /**
   * To test the getLeaveDetails(leaveId) method.
   * @param dao to pass the fake data
   */
  @Test
  public final void testValidGetLeaveDetailsByLeaveId(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.getLeaveDetails(1);
        java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
        java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
        result = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
        }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      public LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails leaveDetails = LeaveDetails.getLeaveDetailsByLeaveId(1);
    assertEquals(1, leaveDetails.getLeaveId());
  }

    /**
   * To test the invalid getLeaveDetails(leaveId) method.
   * @param dao to pass the fake data
   */
  @Test
  public final void testNotValidGetLeaveDetailsByLeaveId(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.getLeaveDetails(1);
        java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
        java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
        result = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
        }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      public LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails leaveDetails = LeaveDetails.getLeaveDetailsByLeaveId(1);
    assertNotEquals(2, leaveDetails.getLeaveId());
  }
  /**
   * To test the applyForLeave() method.
   * @param dao for the fake data
   */
  @Test
  public final void testValidApplyForLeave(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
      {
        java.sql.Date tempDateStart = new java.sql.Date(119, 02, 04);
        java.sql.Date tempDateEnd = new java.sql.Date(119, 02, 05);
        dao.applyLeave("EL", tempDateStart, tempDateEnd, 2, "reason", 100);
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      public LeaveDetailsDAO dao() {
        return dao;
      }
    };
    java.sql.Date tempDateStart = new java.sql.Date(119, 02, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(119, 02, 05);
    int rowsInserted = dao.applyLeave("EL", tempDateStart, tempDateEnd, 2, "reason", 100);
    assertEquals(1, rowsInserted);
  }

  /**
   * To test the invaild applyForLeave() method.
   * @param dao for the fake data
   */
  @Test
  public final void testNotValidApplyForLeave(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails leaveDetails = new LeaveDetails();
    final Employee employee = new Employee();
    java.sql.Date tempDateStart = new java.sql.Date(119, 02, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(119, 02, 05);
    leaveDetails.setStartDate(tempDateStart);
    leaveDetails.setEndDate(tempDateEnd);
    leaveDetails.setLeaveType("EL");
    leaveDetails.setNoOfDays(2);
    leaveDetails.setReason("Reason");
    leaveDetails.setEmplId(1000);
    new Expectations() {
      {
        dao.applyLeave(leaveDetails.getLeaveType(), leaveDetails.getStartDate(), leaveDetails.getEndDate(), leaveDetails.getNoOfDays(), leaveDetails.getReason(), leaveDetails.getEmplId());
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      public LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int rowsInserted = LeaveDetails.applyLeave(leaveDetails, employee);
    assertNotEquals(0, rowsInserted);
  }

  /**
   * To test the LeaveDetails equals() method.
   */
  @Test
  public final void testLeaveDetailsEquals() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails1 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    LeaveDetails tempLeaveDetails2 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertEquals(true, tempLeaveDetails1.equals(tempLeaveDetails2));
  }

  /**
   * To test the LeaveDetails equals() method.
   */
  @Test
  public final void testNotLeaveDetailsEquals() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails1 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    LeaveDetails tempLeaveDetails2 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertNotEquals(false, tempLeaveDetails1.equals(tempLeaveDetails2));
  }

  /**
   * To test the LeaveDetails hashCode() method.
   */
  @Test
  public final void testHashCode() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails1 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    LeaveDetails tempLeaveDetails2 = new LeaveDetails(1, "EL", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertEquals(tempLeaveDetails1.hashCode(), tempLeaveDetails2.hashCode());
  }

  /**
   * To test the LeaveDetails hashCode() method.
   */
  @Test
  public final void testNotHashCode() {
    java.sql.Date tempDateStart = new java.sql.Date(2019, 03, 04);
    java.sql.Date tempDateEnd = new java.sql.Date(2019, 03, 05);
    LeaveDetails tempLeaveDetails1 = new LeaveDetails(1, "EL", tempDateEnd, tempDateStart, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 3000);
    LeaveDetails tempLeaveDetails2 = new LeaveDetails(2, "LOP", tempDateStart, tempDateEnd, 2, "PENDING", "SPECIFIC", "MANAGER SPECIFIC", 2000);
    assertNotEquals(tempLeaveDetails1.hashCode(), tempLeaveDetails2.hashCode());
  }

  /**
   * To test the isValid() method.
   */
  @Test
  public final void testValidIsValid() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String date = "12-03-2019";
    assertEquals(true, leaveDetails.isValid(date));
  }

  /**
   * To test the isValid() method.
   */
  @Test
  public final void testNotValidIsValid() {
    LeaveDetails leaveDetails = new LeaveDetails();
    String date = "12-03-2019";
    assertNotEquals(false, leaveDetails.isValid(date));
  }
}
