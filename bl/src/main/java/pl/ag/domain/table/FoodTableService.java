package pl.ag.domain.table;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

@Service
public class FoodTableService {

  private final FoodTableRepository foodTableRepository;


  public FoodTableService(FoodTableRepository foodTableRepository) {
    this.foodTableRepository = foodTableRepository;
  }

  public void addFood(AggregateId foodId, double foodCount, UserId userId) {
    FoodTable foodTable = this.loadOrCreateFoodTableForToday(userId);
    foodTable.addFood(foodId, BigDecimal.valueOf(foodCount));
    this.foodTableRepository.save(foodTable);
  }

  public void removeFood(LogId logId, UserId userId) throws ClassNotFoundException {
    FoodTable foodTable = this.loadTodayFoodTable(userId);
    foodTable.removeFood(logId);
    this.foodTableRepository.save(foodTable);
  }

  public void updateFood(LogId logId, double foodCount, UserId userId)
      throws ClassNotFoundException {
    FoodTable foodTable = this.loadTodayFoodTable(userId);
    foodTable.updateFood(logId, BigDecimal.valueOf(foodCount));
    this.foodTableRepository.save(foodTable);
  }

  private FoodTable loadOrCreateFoodTableForToday(UserId userId) {
    FoodTable table = this.foodTableRepository.load(LocalDate.now(), userId);

    if (table != null) {
      return table;
    }

    table = new FoodTable(userId);
    this.foodTableRepository.save(table);
    return table;
  }

  private FoodTable loadTodayFoodTable(UserId userId) throws ClassNotFoundException {
    FoodTable foodTable = this.foodTableRepository.load(LocalDate.now(), userId);
    if (foodTable == null) {
      throw new ClassNotFoundException("Cannot remove or update position which not exists...");
    }
    return foodTable;
  }

}
