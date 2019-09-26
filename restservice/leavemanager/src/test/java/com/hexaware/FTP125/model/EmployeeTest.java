package com.hexaware.FTP125.model;

import com.hexaware.FTP125.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
  }


  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);
    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
   * list employee details by id.
   * @param dao id to get employee details.
   */
  @Test

   public final void testListByLeaveId(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(1);
    new Expectations() {
      {
        dao.listByLeaveId(1); result = e100;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listEmpDetailsByLeaveId(1);
    assertEquals(e100, e);

  }
/**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void testUpdateLeave(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.updateLeaveBalance(100, 23);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee.updateLeave(100, 23);
    assertTrue(true);
  }
  /**
   * Tests the manager details.
   * @param dao for calling dao class.
   */
  @Test

  public final void testManagerDetailsByEmpId(@Mocked final EmployeeDAO dao) {
    final Employee emp = new Employee(100, "manju", 9876543210L, "manju@gmail.com", 101, 24, 100);
    new Expectations() {
        {
          dao.findManager(100); result = emp;


        }
      };
    new MockUp<Employee>() {
        @Mock
    EmployeeDAO dao() {
          return dao;
        }
      };
    Employee e = Employee.displayManagerDetails(100);
    assertEquals(100, e.getEmpId());
   // e = Employee.displayManagerDetails(-1);
   // assertNull(e);
  }

  /**
   * to test hashCode of employee.
   */
  @Test
  public final void testEmployeeHashCode() {
    Employee employee = new Employee(2001, "Ramya", 9841912698L, "ramya@gmail.com", 125, 24, 2000);
    Employee employee1 = new Employee(2001, "Ramya", 9841912698L, "ramya@gmail.com", 125, 24, 2000);
    assertEquals(employee.hashCode(), employee1.hashCode());
  }

  /**
   * to test for wrong hashCode of employee.
   */
  @Test
  public final void testEmployeeNotHashCode() {
    Employee employee = new Employee(3001, "Manjula", 9321654987L, "manjula@gmail.com", 125, 24, 2001);
    Employee employee1 = new Employee(3000, "Manjula", 9321654987L, "manju@gmail.com", 125, 24, 2000);
    assertNotEquals(employee.hashCode(), employee1.hashCode());
  }

  /**
   * to test for toString of employee.
   */
  @Test
  public final void testEmployeetoString() {
    Employee employee = new Employee(2000, "Velmurugan", 9874563210L, "velmurugan@gmail.com", 125, 24, 1000);
    Employee employee1 = new Employee(2000, "Velmurugan", 9874563210L, "velmurugan@gmail.com", 125, 24, 1000);
    assertEquals(employee.toString(), employee1.toString());
  }

  /**
   * to test for wrong toString of employee.
   */
  @Test
  public final void testEmployeeFalsetoString() {
    Employee employee = new Employee(3001, "Manjula", 9321654987L, "manjula@gmail.com", 125, 24, 2001);
    Employee employee1 = new Employee(3000, "Manjula", 9321654987L, "manju@gmail.com", 125, 24, 2000);
    assertNotEquals(employee.toString(), employee1.toString());
  }

  /**
   * to test not equals of employee.
   */
  @Test
  public final void testEmployeeNotEquals() {
    Employee employee = new Employee(3000, "Pradeep", 998745612L, "pradeep@gmail.com", 125, 24, 2000);
    Employee employee1 = new Employee(3000, "Pradeep Kumar", 9250045612L, "pradeep@gmail.com", 125, 24, 2000);
    assertNotEquals(employee, employee1);
  }

  /**
   * Test tha a empid setter.
   */

  @Test
  public final void testEmployeeSetEmpId() {
    Employee employee = new Employee();
    employee.setEmpId(1000);
    assertEquals(1000, employee.getEmpId());
  }

  /**
   * Tests the empId assertNotEquals of employee works correctly.
   */
  public final void testInvalidSetEmpId() {
    Employee employee = new Employee();
    employee.setEmpId(1000);
    assertNotEquals(1001, employee.getEmpId());
  }
  /**
   * Tests the empName assertEquals of employee works correctly.
   */
  @Test
  public final void testSetEmpName() {
    Employee employee = new Employee();
    employee.setEmpName("VELMURUGAN");
    assertEquals("VELMURUGAN", employee.getEmpName());
  }

  /**
   * Tests the empName assertNotEquals of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpName() {
    Employee employee = new Employee();
    employee.setEmpName("VELMURUGAN");
    assertNotEquals("MURUGAN", employee.getEmpName());
  }

  /**
   * Tests the empEmail of employee works correctly.
   */

  @Test
  public final void testSetEmpEmail() {
    Employee employee = new Employee();
    employee.setEmpEmail("velmurugan@gmail.com");
    assertEquals("velmurugan@gmail.com", employee.getEmpEmail());
  }

  /**
   * Tests the incorrect empEmail of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpEmail() {
    Employee employee = new Employee();
    employee.setEmpEmail("velmurugan@gmail.com");
    assertNotEquals("vel@gmail.com", employee.getEmpEmail());
  }

  /**
   * Tests the  empPhoneNo of employee works correctly.
   */
  @Test
  public final void testSetEmpPhoneNo() {
    Employee employee = new Employee();
    employee.setEmpPhoneNo(9876545566L);
    assertEquals(9876545566L, employee.getEmpPhoneNo());
  }

  /**
   * Tests the invalid empPhoneNo of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpPhoneNo() {
    Employee employee = new Employee();
    employee.setEmpPhoneNo(9876542313L);
    assertNotEquals(9876232010L, employee.getEmpPhoneNo());
  }

  /**
   * Tests the valid empDeptNo of employee works correctly.
   */
  @Test
  public final void testSetEmpDeptNo() {
    Employee employee = new Employee();
    employee.setEmpDeptNo(101);
    assertEquals(101, employee.getEmpDeptNo());
  }

  /**
   * Tests the invalid empPhoneNo of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpDeptNo() {
    Employee employee = new Employee();
    employee.setEmpDeptNo(101);
    assertNotEquals(102, employee.getEmpPhoneNo());
  }

  /**
   * Tests the valid empLeaveBalance of employee works correctly.
   */
  @Test

   public final void testSetEmpLeaveBalance() {
    Employee employee = new Employee();
    employee.setEmpLeaveBalance(24);
    assertEquals(24, employee.getEmpLeaveBalance());
  }

  /**
   * Tests the invalid empLeaveBalance of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpLeaveBalance() {
    Employee employee = new Employee();
    employee.setEmpLeaveBalance(24);
    assertNotEquals(23, employee.getEmpLeaveBalance());
  }

  /**
   * Tests the valid empManagerId of employee works correctly.
   */
  @Test
  public final void testSetEmpManagerId() {
    Employee employee = new Employee();
    employee.setEmpManagerId(2000);
    assertEquals(2000, employee.getEmpManagerId());
  }

  /**
   * Tests the invalid empManagerId of employee works correctly.
   */
  @Test
  public final void testInvalidSetEmpManagerId() {
    Employee employee = new Employee();
    employee.setEmpManagerId(2000);
    assertNotEquals(2001, employee.getEmpManagerId());
  }

  /**
   * To test the valid isEmpValid method.
   */
  @Test
  public final void testValidIsEmpValid() {
    Employee employee = new Employee();
    assertEquals(true, employee.isEmpValid(2000));
  }

    /**
   * To test the invalid isEmpValid method.
   */
  @Test
  public final void testInValidIsEmpValid() {
    Employee employee = new Employee();
    assertNotEquals(true, employee.isEmpValid(4565));
  }


  /**
   * Test that checks the constructor of Employee for its value assignment.
   */
  @Test
  public final void testEmployeeConstructor() {
    Employee employee = new Employee(2000, "Velmurugan B", 9566580028L, "VELMURUGANB@HEXAWARE.COM", 125, 25, 1000);
    assertEquals(2000, employee.getEmpId());
    assertEquals("Velmurugan B", employee.getEmpName());
    assertEquals(9566580028L, employee.getEmpPhoneNo());
    assertEquals("VELMURUGANB@HEXAWARE.COM", employee.getEmpEmail());
    assertEquals(125, employee.getEmpDeptNo());
    assertEquals(25, employee.getEmpLeaveBalance());
    assertEquals(1000, employee.getEmpManagerId());
  }

  /**
   * Test that checks the constructor of Employee for its value assignment.
   */
  @Test
  public final void testNotEqualsEmployeeConstructor() {
    Employee employee = new Employee(2000, "Velmurugan B", 9566580028L, "VELMURUGANB@HEXAWARE.COM", 125, 25, 1000);
    assertNotEquals(1000, employee.getEmpId());
    assertNotEquals("Jana", employee.getEmpName());
    assertNotEquals(9566780028L, employee.getEmpPhoneNo());
    assertNotEquals("JANA@HEXAWARE.COM", employee.getEmpEmail());
    assertNotEquals(111, employee.getEmpDeptNo());
    assertNotEquals(11, employee.getEmpLeaveBalance());
    assertNotEquals(1111, employee.getEmpManagerId());
  }

  /**
   * To test the Employee equals() method.
   */
  @Test
  public final void testEmployeeEquals() {
    Employee employee1 = new Employee(2000, "Velmurugan B", 9566580028L, "VELMURUGANB@HEXAWARE.COM", 125, 25, 1000);
    Employee employee2 = new Employee(2000, "Velmurugan B", 9566580028L, "VELMURUGANB@HEXAWARE.COM", 125, 25, 1000);
    assertEquals(true, employee1.equals(employee2));
  }
}

