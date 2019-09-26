package com.hexaware.FTP125.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP125.model.Employee;
/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final      StatementContext ctx) throws SQLException {
  /**
   * @return Employee
   */
    Employee emp = new Employee(rs.getInt("EMP_ID"),
        rs.getString("EMP_Name"),
        rs.getLong("PH_NO"),
        rs.getString("EMP_EMAIl"),
        rs.getInt("DEPT_NO"),
        rs.getInt("LEAVE_BALANCE"),
        rs.getInt("MANAGER_ID"));
    return emp;
  }
}
