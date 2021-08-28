package pl.ag.domain.table;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.ag.domain.user.UserId;
import pl.ag.shared.AggregateId;

class FoodTableServiceTest {

  private FoodTableService service;
  private FoodTableRepository repository;
  private FoodTable foodTable;

  @BeforeEach
  void setUp() {
    this.repository = Mockito.mock(FoodTableRepository.class);
    this.service = new FoodTableService(this.repository);
    this.foodTable = Mockito.mock(FoodTable.class);
    Mockito.when(this.repository.load(any(), any())).thenReturn(null);
  }

  @Test
  void testAddFood() {
    //given
    UserId userId = UserId.userId(1);
    AggregateId foodId = AggregateId.generate();

    //when
    service.addFood(foodId, 200, userId);

    //then
    assertFoodTableCreatedAndFoodSaved();
    assertFoodLoaded();
  }

  @Test
  void testAddFood2() {
    //given
    createUserTableForToday();

    //when
    service.addFood(any(), 200, any());

    //then
    assertFoodSaved();
    assertFoodLoaded();
  }

  @Test
  void testUpdateFood() throws ClassNotFoundException {
    //given
    createUserTableForToday();

    //when
    this.service.updateFood(any(), 200, any());

    //then
    assertFoodSaved();
    assertFoodLoaded();
  }

  @Test
  void testUpdateFood2() {

    //when
    Throwable throwable = assertThrows(ClassNotFoundException.class,
        () -> this.service.updateFood(any(), 200, any()));

    //then
    assertEquals("Cannot remove or update position which not exists...", throwable.getMessage());
  }

  @Test
  void testRemoveFood() throws ClassNotFoundException {
    //given
    createUserTableForToday();

    //when
    this.service.removeFood(any(), any());

    //then
    assertFoodSaved();
    assertFoodLoaded();
  }

  @Test
  void testRemoveFood2() {

    //when
    Throwable throwable = assertThrows(ClassNotFoundException.class,
        () -> this.service.removeFood(any(), any()));

    //then
    assertEquals("Cannot remove or update position which not exists...", throwable.getMessage());
  }

  private void createUserTableForToday() {
    Mockito.when(this.repository.load(any(), any())).thenReturn(this.foodTable);
  }

  void assertFoodTableCreatedAndFoodSaved() {
    Mockito.verify(this.repository, Mockito.times(2)).save(any());
  }

  void assertFoodSaved() {
    Mockito.verify(this.repository, Mockito.times(1)).save(any());
  }

  void assertFoodLoaded() {
    Mockito.verify(this.repository, Mockito.times(1)).load(eq(LocalDate.now()), any());
  }

}
