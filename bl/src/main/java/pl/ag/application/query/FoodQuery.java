package pl.ag.application.query;

import java.time.LocalDate;
import java.util.List;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

public interface FoodQuery {

  Food loadFood(AggregateId foodId);

  List<Food> getFoodsByName(String foodName);

  List<UserFood> getDailyUserFood(UserId userId, LocalDate date);
}
