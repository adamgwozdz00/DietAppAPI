package pl.ag;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.flywaydb.core.Flyway;
import org.postgresql.Driver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class RunMigrations {

  public static void main(String[] args) throws IOException {
    new RunMigrations().runMigrations();
  }

  private  void runMigrations() throws IOException {
    InputStream inputStream = getClass().getClassLoader()
        .getResourceAsStream("flyway.properties");
    Properties properties = new Properties();
    properties.load(inputStream);

    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(new Driver());
    dataSource.setUrl(properties.getProperty("flyway.url"));
    dataSource.setUsername(properties.getProperty("flyway.user"));
    dataSource.setPassword(properties.getProperty("flyway.password"));

    Flyway flyway = Flyway.configure().dataSource(dataSource).load();
    flyway.repair();
    flyway.migrate();
  }

}
