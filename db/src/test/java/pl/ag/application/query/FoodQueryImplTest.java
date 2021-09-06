package pl.ag.application.query;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

class FoodQueryImplTest {

  FoodQuery foodQuery;

  @BeforeEach
  void setUp() throws IOException {
    InputStream inputStream = getClass().getClassLoader()
        .getResourceAsStream("jdbc.properties");
    Properties properties = new Properties();
    properties.load(inputStream);

    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(new Driver());
    dataSource.setUrl(properties.getProperty("jdbc.connection.url"));
    dataSource.setUsername(properties.getProperty("jdbc.connection.username"));
    dataSource.setPassword(properties.getProperty("jdbc.connection.password"));

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    foodQuery = new FoodQueryImpl(jdbcTemplate);
  }

  @Test
  void test1() {
    Food food = foodQuery.loadFood(new AggregateId("940b9b6c-f075-11eb-b28a-d0817ac856f2"));
    System.out.println(food);
  }

  @Test
  void test2() {
    foodQuery.getFoodsByName("Chicken").forEach(System.out::println);
  }

  @Test
  void test3() {
    for (UserFood food : foodQuery.getDailyUserFood(UserId.userId(1), LocalDate.now())) {
      System.out.println(food.logId.getLogId() + " " + food.food.calories + " " + food.food.weight);
    }
  }

}
