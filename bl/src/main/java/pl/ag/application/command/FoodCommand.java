package pl.ag.application.command;

import org.springframework.stereotype.Service;
import pl.ag.application.shared.UsersService;
import pl.ag.domain.table.FoodTableService;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

@Service
public class FoodCommand {

  private final UsersService usersService;
  private final FoodTableService foodTableService;

  public FoodCommand(UsersService usersService,
      FoodTableService foodTableService) {
    this.usersService = usersService;
    this.foodTableService = foodTableService;
  }

  public void addCommand(AggregateId foodId, double foodCount) {
    UserId userId = this.usersService.getLoggedUserId();
    this.foodTableService.addFood(foodId, foodCount, userId);
  }

  public void removeCommand(AggregateId logId) throws ClassNotFoundException {
    UserId userId = this.usersService.getLoggedUserId();
    this.foodTableService.removeFood(logId, userId);
  }

  public void updateCommand(AggregateId logId, double foodCount) throws ClassNotFoundException {
    UserId userId = this.usersService.getLoggedUserId();
    this.foodTableService.updateFood(logId, foodCount, userId);
  }


}
