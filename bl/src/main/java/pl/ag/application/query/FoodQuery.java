package pl.ag.application.query;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

@Repository
public interface FoodQuery {

  @Deprecated
  Food loadFood(AggregateId foodId);

  List<Food> getFoodsByName(String foodName);

  List<UserFood> getDailyUserFood(UserId userId, LocalDate date);

  FoodSum sumUserFood(UserId userId, LocalDate date);
}
