package pl.ag.application.query;

import java.util.List;
import pl.ag.shared.AggregateId;

public interface FoodQuery {

  Food loadFood(AggregateId foodId);

  List<Food> getFoodsByName(String foodName);
}
