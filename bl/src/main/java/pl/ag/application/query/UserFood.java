package pl.ag.application.query;

import lombok.Getter;
import pl.ag.domain.table.LogId;

@Getter
public class UserFood {

  final LogId logId;
  final Food food;


  UserFood(LogId logId, Food food) {
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
