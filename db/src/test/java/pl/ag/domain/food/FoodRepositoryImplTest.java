package pl.ag.domain.food;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class FoodRepositoryImplTest {

  @Autowired
  private FoodRepositoryImpl foodRepository;

  @BeforeEach
  void setUp() throws SQLException, IOException {
    Properties properties = new Properties();
    properties.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));

    DataSource ds = new DriverManagerDataSource(properties.getProperty("jdbc.connection.url"),
        properties.getProperty("jdbc.connection.username"),
        properties.getProperty("jdbc.connection.password"));

    JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

    foodRepository = new FoodRepositoryImpl(jdbcTemplate);
  }


  @Test
  void test() {
    List<Food> foods = foodRepository.load("Chicken");
    foods.stream().forEach(System.out::println);
  }

}
