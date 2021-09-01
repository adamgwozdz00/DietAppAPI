package pl.ag.application.query;

import java.math.BigDecimal;

class Food {

  final String name;
  final BigDecimal weight;
  final BigDecimal calories;
  final BigDecimal protein;
  final BigDecimal fat;
  final BigDecimal carbohydrates;

  private Food(Builder builder) {
    this.name = builder.name;
    this.weight = builder.weight;
    this.calories = builder.calories;
    this.protein = builder.protein;
    this.fat = builder.fat;
    this.carbohydrates = builder.carbohydrates;
  }

  public static class Builder {

    private final String name;
    private final BigDecimal weight;

    private BigDecimal calories = BigDecimal.ZERO;
    private BigDecimal protein = BigDecimal.ZERO;
    private BigDecimal fat = BigDecimal.ZERO;
    private BigDecimal carbohydrates = BigDecimal.ZERO;

    public Builder(String name, BigDecimal weight) {
      this.name = name;
      this.weight = weight;
    }

    public Builder calories(BigDecimal val) {
      this.calories = val;
      return this;
    }

    public Builder protein(BigDecimal val) {
      this.protein = val;
      return this;
    }

    public Builder fat(BigDecimal val) {
      this.fat = val;
      return this;
    }

    public Builder carbohydrates(BigDecimal val) {
      this.carbohydrates = val;
      return this;
    }

    public Food build() {
      return new Food(this);
    }
  }

}
