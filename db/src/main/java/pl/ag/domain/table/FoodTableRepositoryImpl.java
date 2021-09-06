package pl.ag.domain.table;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import pl.ag.domain.user.UserId;

public class FoodTableRepositoryImpl implements FoodTableRepository {

  private final EntityManager entityManager;

  public FoodTableRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public FoodTable load(LocalDate day, UserId userId) {
    try{
    return this.entityManager
        .createQuery("SELECT ft FROM FoodTable ft WHERE ft.date =?1 AND ft.userId =?2",
            FoodTable.class).setParameter(1, day)
        .setParameter(2, userId).getSingleResult();
    }catch (NoResultException e){
      return null;
    }
  }

  @Override
  public void save(FoodTable foodTable) {
    this.entityManager.getTransaction().begin();
    this.entityManager.merge(foodTable);
    this.entityManager.getTransaction().commit();
  }
}
