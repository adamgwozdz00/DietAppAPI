package pl.ag.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.ag.domain.table", "pl.ag.application.command", "pl.ag.acl",
    "pl.ag.application.query", "pl.ag.ws"})
@EntityScan(basePackages = "pl.ag.domain.table")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
