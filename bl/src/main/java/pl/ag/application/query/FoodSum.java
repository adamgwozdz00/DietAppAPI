package pl.ag.application.query;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class FoodSum {

  private final BigDecimal calories;
  private final BigDecimal protein;
  private final BigDecimal fat;
  private final BigDecimal carbohydrates;

  FoodSum(BigDecimal calories, BigDecimal protein, BigDecimal fat,
      BigDecimal carbohydrates) {
    this.calories = calories;
    this.protein = protein;
    this.fat = fat;
    this.carbohydrates = carbohydrates;
  }

  @Override
  public String toString() {
    return "FoodSum{" +
        "calories=" + calories +
        ", protein=" + protein +
        ", fat=" + fat +
        ", carbohydrates=" + carbohydrates +
        '}';
  }
}
