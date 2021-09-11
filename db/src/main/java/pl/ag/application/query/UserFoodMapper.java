package pl.ag.application.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pl.ag.domain.table.LogId;

public class UserFoodMapper implements RowMapper<UserFood> {

  @Override
  public UserFood mapRow(ResultSet resultSet, int i) throws SQLException {

    return new UserFood(LogId.logId(resultSet.getLong("logid")),
        new Food(resultSet.getString("id"), resultSet.getString("name"),
            resultSet.getBigDecimal("foodweight"),
            resultSet.getBigDecimal("calories"), resultSet.getBigDecimal("protein"),
            resultSet.getBigDecimal("fat"),
            resultSet.getBigDecimal("carbohydrates")));
  }
}
