package pl.ag.domain.food;

public class FoodService {

  private final FoodRepository repository;

  public FoodService(FoodRepository repository) {
    this.repository = repository;
  }

}
