package pl.ag.domain.table;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

class FoodTableRepositoryImplTest {

  private FoodTableRepositoryImpl foodTableRepository;
  private FoodTableService foodTableService;

  @BeforeEach
  void setUp(){
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    EntityManager em = session.getEntityManagerFactory().createEntityManager();
    foodTableRepository = new FoodTableRepositoryImpl(em);
    foodTableService = new FoodTableService(foodTableRepository);
  }

  @Test
  void test(){
    foodTableService.addFood(new AggregateId("940ba2ba-f075-11eb-b28a-d0817ac856f2"),150,UserId.userId(1));
  }

  @Test
  void test2() throws ClassNotFoundException {
    foodTableService.updateFood(LogId.logId(1L),10,UserId.userId(1));
  }

  @Test
  void test3() throws ClassNotFoundException {
    foodTableService.removeFood(LogId.logId(1L),UserId.userId(1));
  }



}
