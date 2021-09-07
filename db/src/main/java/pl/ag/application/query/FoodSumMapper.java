package pl.ag.application.query;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FoodSumMapper implements RowMapper<FoodSum> {

  @Override
  public FoodSum mapRow(ResultSet resultSet, int i) throws SQLException {
    return new FoodSum(resultSet.getBigDecimal("calories"), resultSet.getBigDecimal("protein"),
        resultSet.getBigDecimal("fat"), resultSet.getBigDecimal("carbohydrates"));
  }
}
