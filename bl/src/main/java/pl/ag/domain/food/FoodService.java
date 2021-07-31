package pl.ag.domain.food;

import pl.ag.shared.AggregateId;

public class FoodService {

  private final FoodRepository repository;

  public FoodService(FoodRepository repository) {
    this.repository = repository;
  }


}
