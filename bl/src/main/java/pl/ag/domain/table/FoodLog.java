package pl.ag.domain.table;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import pl.ag.shared.AggregateId;

@Entity
class FoodLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private LogId id;
  private AggregateId foodId;
  private BigDecimal foodWeight;

  private FoodLog() {
  }

  // test constructor, don't use in production!
  FoodLog(LogId id, AggregateId foodId, BigDecimal foodWeight) {
    this.id = id;
    this.foodId = foodId;
    vetoIfFoodWeightLowerThanOneGram(foodWeight);
    this.foodWeight = foodWeight;
  }

  FoodLog(AggregateId foodId,
      BigDecimal foodWeight) {
    this(foodId);
    vetoIfFoodWeightLowerThanOneGram(foodWeight);
    this.foodWeight = foodWeight;
  }

  FoodLog(AggregateId foodId) {
    this.foodId = foodId;
    this.foodWeight = BigDecimal.valueOf(100);
  }

  void changeFoodWeight(BigDecimal foodWeight) {
    vetoIfFoodWeightLowerThanOneGram(foodWeight);

    this.foodWeight = foodWeight;
  }

  boolean isIdTheSame(LogId id) {
    return this.id.equals(id);
  }

  boolean isFoodIdAndWeightMatches(AggregateId foodId, BigDecimal weight) {
    return this.foodId.equals(foodId) && this.foodWeight.equals(weight);
  }

  private void vetoIfFoodWeightLowerThanOneGram(BigDecimal foodWeight) {
    if (this.isFoodWeightHigherLowerZero(foodWeight)) {
      throw new IllegalArgumentException("Food weight is lower than zero!");
    }
  }

  private boolean isFoodWeightHigherLowerZero(BigDecimal foodWeight) {
    return foodWeight.compareTo(BigDecimal.ZERO) < 1;
  }


}
