package pl.ag.application.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FoodRowMapper implements RowMapper<Food> {

  @Override
  public Food mapRow(ResultSet resultSet, int i) throws SQLException {
    return new Food(resultSet.getString("id"), resultSet.getString("name"),
        resultSet.getBigDecimal("weight"),
        resultSet.getBigDecimal("calories"), resultSet.getBigDecimal("protein"),
        resultSet.getBigDecimal("fat"), resultSet.getBigDecimal("carbohydrates"));
  }
}
