package pl.ag.domain.food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.ag.shared.AggregateId;

public class FoodRepositoryImpl implements FoodRepository {


  private final JdbcTemplate jdbcTemplate;

  public FoodRepositoryImpl(
      JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Food> load(String name) {
    String query = String.format("SELECT id, name FROM FOOD WHERE name = '%s'", name);
    List<Food> foodlist = jdbcTemplate.query(query,
        new RowMapper<Food>() {
          @Override
          public Food mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Food(new AggregateId(resultSet.getString("id")),
                resultSet.getString("name"));
          }
        });

    if (foodlist.isEmpty()) {
      return Collections.emptyList();
    }
    return foodlist;
  }

}
