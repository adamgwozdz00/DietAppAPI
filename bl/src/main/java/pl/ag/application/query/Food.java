package pl.ag.application.query;

import java.math.BigDecimal;

class Food {

  final String name;
  final BigDecimal weight;
  final BigDecimal calories;
  final BigDecimal protein;
  final BigDecimal fat;
  final BigDecimal carbohydrates;


  Food(String name, BigDecimal weight, BigDecimal calories, BigDecimal protein,
      BigDecimal fat, BigDecimal carbohydrates) {
    this.name = name;
    this.weight = weight;
    this.calories = calories;
    this.protein = protein;
    this.fat = fat;
    this.carbohydrates = carbohydrates;
  }

  @Override
  public String toString() {
    return "Food{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        ", calories=" + calories +
        ", protein=" + protein +
        ", fat=" + fat +
        ", carbohydrates=" + carbohydrates +
        '}';
  }
}
