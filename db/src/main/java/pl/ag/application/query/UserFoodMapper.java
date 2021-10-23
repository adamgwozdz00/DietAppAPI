package pl.ag.application.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pl.ag.shared.AggregateId;

public class UserFoodMapper implements RowMapper<UserFood> {

  @Override
  public UserFood mapRow(ResultSet resultSet, int i) throws SQLException {

    return new UserFood(new AggregateId(resultSet.getString("logid")),
        new Food(resultSet.getString("id"), resultSet.getString("name"),
            resultSet.getBigDecimal("foodweight"),
            resultSet.getBigDecimal("calories"), resultSet.getBigDecimal("protein"),
            resultSet.getBigDecimal("fat"),
            resultSet.getBigDecimal("carbohydrates")));
  }
}
