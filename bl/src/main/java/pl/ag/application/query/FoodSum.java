package pl.ag.application.query;

import java.math.BigDecimal;

class FoodSum {

  final BigDecimal calories;
  final BigDecimal protein;
  final BigDecimal fat;
  final BigDecimal carbohydrates;

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
