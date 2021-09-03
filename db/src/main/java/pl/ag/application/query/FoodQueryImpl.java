package pl.ag.application.query;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.ag.shared.AggregateId;

public class FoodQueryImpl implements FoodQuery {

  private final JdbcTemplate jdbcTemplate;
  private final String QUERY_FOOD_BY_ID = "SELECT * from Food WHERE id = '%s'";
  private final String QUERY_FOOD_BY_NAME = "SELECT * FROM Food WHERE name LIKE %s";

  public FoodQueryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Food loadFood(AggregateId foodId) {
    return this.jdbcTemplate
        .queryForObject(String.format(QUERY_FOOD_BY_ID, foodId), new FoodRowMapper());
  }

  @Override
  public List<Food> getFoodsByName(String foodName) {
    return this.jdbcTemplate
        .query(String.format(QUERY_FOOD_BY_NAME, "'%" + foodName + "%'"), new FoodRowMapper());
  }

}
