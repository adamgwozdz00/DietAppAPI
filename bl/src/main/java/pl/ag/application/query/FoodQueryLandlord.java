package pl.ag.application.query;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.ag.application.shared.UsersService;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

@Service
public class FoodQueryLandlord {

  private final UsersService usersService;
  private final FoodQuery foodQuery;

  public FoodQueryLandlord(UsersService usersService, FoodQuery foodQuery) {
    this.usersService = usersService;
    this.foodQuery = foodQuery;
  }

  public Food loadFood(AggregateId foodId) {
    return this.foodQuery.loadFood(foodId);
  }

  public List<Food> getFoodsByName(String foodName) {
    return this.foodQuery.getFoodsByName(foodName);
  }

  public List<UserFood> getDailyUserFood(LocalDate date) {
    UserId userId = usersService.getLoggedUserId();
    return this.foodQuery.getDailyUserFood(userId, date);
  }

  public FoodSum sumUserFood(LocalDate date) {
    UserId userId = usersService.getLoggedUserId();
    return this.foodQuery.sumUserFood(userId, date);
  }
}
