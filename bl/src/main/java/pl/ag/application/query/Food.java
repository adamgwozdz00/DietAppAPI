package pl.ag.application.query;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class Food {

  private final String foodId;
  private final String name;
  private final BigDecimal weight;
  private final BigDecimal calories;
  private final BigDecimal protein;
  private final BigDecimal fat;
  private final BigDecimal carbohydrates;


  Food(String foodId, String name, BigDecimal weight, BigDecimal calories, BigDecimal protein,
      BigDecimal fat, BigDecimal carbohydrates) {
    this.foodId = foodId;
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
