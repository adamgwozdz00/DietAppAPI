package pl.ag.ws;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserFoodEndpoint {

  @GetMapping("/food")
  public String[] loadUserFoodList() {
    return new String[]{"CHICKEN", "FISH", "EGG"};
  }

  @GetMapping("/food/list")
  public List<String> loadFoodsByName(@RequestParam String foodName) {
    System.out.println(foodName);
    return Arrays.asList("Boiled Chicken ", "Grilled Chicken", "Raw Chicken");
  }


  @PostMapping("food/add")
  public String addFood() {
    return "adding food...";
  }

  @PostMapping("food/remove")
  public String removeFood() {
    return "removing food...";
  }

  @PostMapping("food/update")
  public String updateFood() {
    return "updating food...";
  }
}
