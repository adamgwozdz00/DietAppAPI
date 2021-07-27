package pl.ag.bl.food;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import shared.AggregateId;
import shared.NutritionalValue;


@Entity
@Embeddable
class Food {

  @Id
  private AggregateId id;
  private String name;
  private NutritionalValue weight;
  private NutritionalValue calories;
  private NutritionalValue protein;
  private NutritionalValue fat;
  private NutritionalValue carbohydrates;

  private Food() {
  }

  private Food(Builder builder) {
    this.id = AggregateId.generate();
    this.name = builder.name;
    this.weight = builder.weight;
    this.calories = builder.calories;
    this.protein = builder.protein;
    this.fat = builder.fat;
    this.carbohydrates = builder.carbohydrates;
  }

  void increaseWeightBy(double multiply) {
    this.increaseWeightBy(new NutritionalValue(multiply));
  }


  boolean compareFoodDetails(Food food) {
    if (!this.calories.compare(food.calories)) {
      return false;
    }

    if (!this.protein.compare(food.protein)) {
      return false;
    }

    if (!this.fat.compare(food.fat)) {
      return false;
    }

    if (!this.carbohydrates.compare(food.carbohydrates)) {
      return false;
    }

    return true;
  }

  boolean isWeightEquals(double weight) {
    return this.weight.compare(new NutritionalValue(weight));
  }

  void increaseWeightTo(double value) {
    NutritionalValue multiply = new NutritionalValue(value);
    multiply.divide(this.weight);
    this.increaseWeightBy(multiply);
  }

  private void increaseWeightBy(NutritionalValue multiply) {
    this.weight.multiply(multiply);
    this.calories.multiply(multiply);
    this.protein.multiply(multiply);
    this.fat.multiply(multiply);
    this.carbohydrates.multiply(multiply);
  }

  static class Builder {

    private final String name;
    private final NutritionalValue weight;
    private final NutritionalValue calories;
    private NutritionalValue protein = NutritionalValue.ZERO();
    private NutritionalValue fat = NutritionalValue.ZERO();
    private NutritionalValue carbohydrates = NutritionalValue.ZERO();

    Builder(String name, double weight, double calories) {
      this.name = name;
      this.weight = new NutritionalValue(weight);
      this.calories = new NutritionalValue(calories);
    }

    Builder protein(double protein) {
      this.protein = new NutritionalValue(protein);
      return this;
    }

    Builder fat(double fat) {
      this.fat = new NutritionalValue(fat);
      return this;
    }

    Builder carbohydrates(double carbohydrates) {
      this.carbohydrates = new NutritionalValue(carbohydrates);
      return this;
    }

    Food build() {
      return new Food(this);
    }

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
