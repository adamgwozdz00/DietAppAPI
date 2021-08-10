package pl.ag.domain.table;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;
import pl.ag.domain.user.UserId;

@Repository
public interface FoodTableRepository {

  FoodTable load(LocalDate day, UserId userId);

  void save(FoodTable foodTable);
}
