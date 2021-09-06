package pl.ag.domain.table;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import pl.ag.shared.AggregateId;

@Entity
@IdClass(LogId.class)
class FoodLog {

  @Id
  @GeneratedValue
  private Long logId;
  private AggregateId foodId;
  private BigDecimal foodWeight;

  private FoodLog() {
  }

  // test constructor, don't use in production!
  FoodLog(Long logId, AggregateId foodId, BigDecimal foodWeight) {
    this.logId = logId;
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

  boolean isIdTheSame(LogId logId) {
    return this.logId.equals(logId.getLogId());
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
