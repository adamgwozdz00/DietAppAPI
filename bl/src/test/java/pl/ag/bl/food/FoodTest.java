package pl.ag.bl.food;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FoodTest {

  Food food;

  @Test
  void test1() {
    food("Chicken", 100.77, 107.21, 21, 3, 0);

    increaseFoodWeight().by(4);

    assertFoodWeight(403.08);
    assertFoodDetails(428.84, 84, 12, 0);
  }

  @Test
  void test2() {
    food("Chicken", 100.77, 107.21, 21, 3, 0);

    increaseFoodWeight().to(403.08);

    assertFoodWeight(403.08);
    assertFoodDetails(428.84, 84, 12, 0);
  }


  private void assertFoodWeight(double weight) {
    assertTrue(food.isWeightEquals(weight));
  }

  private void assertFoodDetails(double calories, double protein, double fat, double carbo) {
    boolean result = this.food.compareFoodDetails(new Food.Builder(" ", 100, calories)
        .protein(protein)
        .fat(fat)
        .carbohydrates(carbo)
        .build());
    assertTrue(result);
  }

  private FoodAssertAssembler increaseFoodWeight() {
    return new FoodAssertAssembler();
  }

  private void food(String foodName, double weight, double calories, double protein, double fat,
      double carbo) {
    this.food = new Food.Builder(foodName, weight, calories)
        .protein(protein)
        .fat(fat)
        .carbohydrates(carbo)
        .build();
  }

  private class FoodAssertAssembler {


    public void by(double multiply) {
      food.increaseWeightBy(multiply);
    }

    public void to(double value) {
      food.increaseWeightTo(value);
    }
  }
}
