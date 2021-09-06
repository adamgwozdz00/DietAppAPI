package pl.ag.domain.table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

@Entity
class FoodTable {

  @EmbeddedId
  @AttributeOverrides({
      @AttributeOverride(name = "aggregateId", column = @Column(name = "id"))
  })
  private AggregateId id;

  private UserId userId;

  private LocalDate date;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "table_id")
  private List<FoodLog> foodLogList;

  FoodTable(UserId userId) {
    this.id = AggregateId.generate();
    this.userId = userId;
    this.date = LocalDate.now();
    this.foodLogList = new ArrayList<>();
  }

  private FoodTable() {
  }

  void addFood(AggregateId foodId, BigDecimal foodWeight) {
    this.foodLogList.add(new FoodLog(foodId, foodWeight));
  }

  void removeFood(LogId foodLogId) {
    this.vetoIfFoodNotInTable(foodLogId);

    this.foodLogList.removeIf(foodLog -> foodLog.isIdTheSame(foodLogId));
  }

  void updateFood(LogId foodLogId, BigDecimal foodWeight) {
    this.vetoIfFoodNotInTable(foodLogId);

    this.foodLogList.stream()
        .filter(foodLog -> foodLog.isIdTheSame(foodLogId))
        .findFirst()
        .get()
        .changeFoodWeight(foodWeight);
  }

  boolean checkFoodCount(int count) {
    return this.foodLogList.size() == count;
  }

  boolean checkFoodWeight(AggregateId foodId, BigDecimal foodWeight) {
    return foodLogList.stream()
        .anyMatch(foodLog -> foodLog.isFoodIdAndWeightMatches(foodId, foodWeight));
  }

  private void vetoIfFoodNotInTable(LogId foodId) {
    if (this.foodNotInTable(foodId)) {
      throw new IllegalArgumentException(String.format("Food with id: %s not in table.", foodId));
    }
  }

  private boolean foodNotInTable(LogId foodLogId) {
    return this.foodLogList.stream().noneMatch(foodLog -> foodLog.isIdTheSame(foodLogId));
  }


}
