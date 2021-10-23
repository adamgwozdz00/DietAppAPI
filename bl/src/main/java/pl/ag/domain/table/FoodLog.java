package pl.ag.domain.table;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import pl.ag.shared.AggregateId;

@Entity
@Table(name = "foodlog")
class FoodLog {

  @EmbeddedId
  @AttributeOverrides({
      @AttributeOverride(name = "aggregateId", column = @Column(name = "logid"))
  })
  private AggregateId logId;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "aggregateId", column = @Column(name = "foodid"))
  })
  private AggregateId foodId;
  @Column(name = "foodweight")
  private BigDecimal foodWeight;

  private FoodLog() {
  }

  // test constructor, don't use in production!
  FoodLog(AggregateId logId, AggregateId foodId, BigDecimal foodWeight) {
    this.logId = logId;
    this.foodId = foodId;
    vetoIfFoodWeightLowerThanOneGram(foodWeight);
    this.foodWeight = foodWeight;
  }

  FoodLog(AggregateId foodId,
      BigDecimal foodWeight) {
    this.logId = AggregateId.generate();
    this.foodId = foodId;
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

  boolean isIdTheSame(AggregateId logId) {
    return this.logId.equals(logId);
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
