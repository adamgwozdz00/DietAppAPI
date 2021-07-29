package pl.ag.domain.foodlog;

import pl.ag.shared.AggregateId;
import pl.ag.shared.NutritionalValue;

class FoodLog {

  private AggregateId id;
  private AggregateId foodId;
  private AggregateId userId;
  private NutritionalValue foodWeight;

  FoodLog(AggregateId foodId, AggregateId userId,
      NutritionalValue foodWeight) {
    this(foodId, userId);
    this.foodWeight = foodWeight;
  }

  FoodLog(AggregateId foodId, AggregateId userId) {
    this.id = AggregateId.generate();
    this.foodId = foodId;
    this.userId = userId;
  }
}
