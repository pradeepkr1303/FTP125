package com.hexaware.FTP125.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP125.model.LeaveDetails;
/**
 * Mapper class to map from result set to employee object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
  /**
   * @return Employee
   */
    LeaveDetails ld = new LeaveDetails(rs.getInt("LEAVE_ID"),
        rs.getString("LEAVE_TYPE"),
        rs.getDate("START_DATE"),
        rs.getDate("END_DATE"),
        rs.getInt("NO_OF_DAYS"),
        rs.getString("LEAVE_STATUS"),
        rs.getString("REASON"),
        rs.getString("MANAGER_COMMENTS"),
        rs.getInt("EMP_ID"));
    return ld;
  }
}
