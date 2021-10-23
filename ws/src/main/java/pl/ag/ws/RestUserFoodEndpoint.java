package pl.ag.ws;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ag.application.command.FoodCommand;
import pl.ag.application.query.Food;
import pl.ag.application.query.FoodQueryLandlord;
import pl.ag.application.query.FoodSum;
import pl.ag.application.query.UserFood;
import pl.ag.shared.AggregateId;

@RestController
public class RestUserFoodEndpoint {

  @Autowired
  private FoodCommand foodCommand;

  @Autowired
  private FoodQueryLandlord foodQueryLandlord;

  @GetMapping("/")
  public String test() {
    return "hello";
  }

  @GetMapping("/food/account")
  @ResponseBody
  //TODO changing diet table day
  public List<UserFood> loadUserFoodList() {
    return foodQueryLandlord.getDailyUserFood(LocalDate.now());
  }

  @GetMapping("/food/list")
  @ResponseBody
  public List<Food> loadFoodsByName(@RequestParam String foodName) {
    return foodQueryLandlord.getFoodsByName(foodName);
  }

  @GetMapping("/food/account/sum")
  @ResponseBody
  public FoodSum countTotalNutritional() {
    return foodQueryLandlord.sumUserFood(LocalDate.now());
  }

  @PostMapping("food/account/add")
  public String addFood(@RequestParam String foodId, @RequestParam double foodCount) {
    this.foodCommand.addCommand(new AggregateId(foodId), foodCount);
    return "SUCCESS";
  }

  @PostMapping("food/account/remove")
  public String removeFood(@RequestParam String logId) {
    try {
      this.foodCommand.removeCommand(new AggregateId(logId));
      return "SUCCESS";
    } catch (ClassNotFoundException e) {
      return "FAILURE";
    }
  }

  @PostMapping("food/account/update")
  public String updateFood(@RequestParam String logId, @RequestParam double foodCount) {
    try {
      this.foodCommand.updateCommand(new AggregateId(logId), foodCount);
      return "SUCCESS";
    } catch (ClassNotFoundException e) {
      return "FAILURE";
    }
  }
}
