package pl.ag.domain.table;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

class FoodTableTest {

  FoodTable table;
  Map<AggregateId, BigDecimal> food;
  Throwable throwable;


  @BeforeEach
  void setUp() {
    this.table = new FoodTable(UserId.userId(1));
    this.food = new HashMap<>();
  }

  @Test
  void testAddFood1() {
    food("chicken", 200);

    toTableAddFood("chicken");

    assertFoodCount(1);
    assertFoodInTable("chicken", 200);
  }

  @Test
  void testAddFood2() {
    food("chicken", 200);
    food("rice", 100);
    food("carrot", 50);

    toTableAddFood("chicken");
    toTableAddFood("rice");
    toTableAddFood("carrot");

    assertFoodCount(3);
    assertFoodInTable("chicken", 200);
    assertFoodInTable("rice", 100);
    assertFoodInTable("carrot", 50);
  }


  private void assertFoodInTable(String foodName, double foodWeight) {
    boolean actual = this.table
        .checkFoodWeight(new AggregateId(foodName), BigDecimal.valueOf(foodWeight));
    assertTrue(actual);
  }


  private void assertFoodCount(int count) {
    boolean actual = this.table.checkFoodCount(count);
    assertTrue(actual);
  }

  private void toTableAddFood(String foodName) {
    BigDecimal foodWeight = this.food.get(new AggregateId(foodName));

    this.table.addFood(new AggregateId(foodName), foodWeight);

  }

  private void food(String foodName, double foodWeight) {
    this.food.put(new AggregateId(foodName), BigDecimal.valueOf(foodWeight));
  }

  private void food(String foodName) {
    this.food.put(new AggregateId(foodName), null);
  }

}
