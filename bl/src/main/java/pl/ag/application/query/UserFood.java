package pl.ag.application.query;

import lombok.Getter;
import pl.ag.shared.AggregateId;

@Getter
public class UserFood {

  final AggregateId logId;
  final Food food;


  UserFood(AggregateId logId, Food food) {
    this.logId = logId;
    this.food = food;
  }

  @Override
  public String toString() {
    return "UserFood{" +
        "logId=" + logId +
        ", food=" + food +
        '}';
  }


}
