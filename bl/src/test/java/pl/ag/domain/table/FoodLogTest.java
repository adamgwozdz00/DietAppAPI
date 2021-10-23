package pl.ag.domain.table;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.ag.shared.AggregateId;

class FoodLogTest {

  FoodLog foodLog;
  Throwable throwable;

  @BeforeEach
  void setUp() {

  }

  @Test
  void test1() {
    log("1", "1", 300);

    changeFoodWeight(100);

    assertLogId("1");
    assertFoodWeight("1", 100);
  }


  @Test
  void test2() {
    log("1", "1", 300);

    changeFoodWeight(0);

    assertException(IllegalArgumentException.class, "Food weight is lower than zero!");
  }

  private void assertLogId(String logId) {
    assertTrue(this.foodLog.isIdTheSame(new AggregateId(logId)));
  }

  private void assertFoodWeight(String foodId, double foodWeight) {
    boolean actual = this.foodLog
        .isFoodIdAndWeightMatches(new AggregateId(foodId), BigDecimal.valueOf(foodWeight));
    assertTrue(actual);

  }

  private void log(String logId, String foodId, double weight) {
    this.foodLog = new FoodLog(new AggregateId(logId), new AggregateId(foodId),
        BigDecimal.valueOf(weight));
  }

  private void changeFoodWeight(double newWeight) {
    try {
      this.foodLog.changeFoodWeight(BigDecimal.valueOf(newWeight));

    } catch (Throwable e) {
      this.throwable = e;
    }
  }

  private void assertException(Class<? extends Throwable> exceptionClass, String message) {
    assertEquals(exceptionClass, throwable.getClass());
    assertEquals(message, throwable.getMessage());
  }
}
