package pl.ag.domain.food;

import java.util.List;

public interface FoodRepository {

  List<Food> load(String name);

}
