package pl.ag.application.query;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pl.ag.domain.table.LogId;

public class UserFoodMapper implements RowMapper<UserFood> {

  @Override
  public UserFood mapRow(ResultSet resultSet, int i) throws SQLException {
    BigDecimal weight = resultSet.getBigDecimal("foodweight");
    BigDecimal multiplier = weight.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    BigDecimal calories = resultSet.getBigDecimal("calories").multiply(multiplier);
    BigDecimal protein = resultSet.getBigDecimal("protein").multiply(multiplier);
    BigDecimal fat = resultSet.getBigDecimal("fat").multiply(multiplier);
    BigDecimal carbohydrates = resultSet.getBigDecimal("carbohydrates").multiply(multiplier);

    return new UserFood(LogId.logId(resultSet.getLong("logid")),
        new Food(resultSet.getString("name"), weight, calories, protein, fat, carbohydrates));
  }
}
