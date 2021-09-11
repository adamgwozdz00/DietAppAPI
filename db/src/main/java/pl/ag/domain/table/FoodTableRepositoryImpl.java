package pl.ag.domain.table;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import pl.ag.domain.user.UserId;

@Repository
@EntityScan(basePackageClasses = pl.ag.domain.table.FoodTable.class)
@Transactional
public class FoodTableRepositoryImpl implements FoodTableRepository {

  @PersistenceContext
  private final EntityManager entityManager;

  public FoodTableRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public FoodTable load(LocalDate day, UserId userId) {
    try {
      return this.entityManager
          .createQuery("SELECT ft FROM FoodTable ft WHERE ft.date =?1 AND ft.userId =?2",
              FoodTable.class).setParameter(1, day)
          .setParameter(2, userId).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Override
  public void save(FoodTable foodTable) {
    this.entityManager.merge(foodTable);
  }
}
