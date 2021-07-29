package pl.ag.domain.food;


import pl.ag.shared.AggregateId;


class Food {

  private final AggregateId id;
  private final String name;

  public Food(AggregateId id, String name) {
    this.id = id;
    this.name = name;
  }

  AggregateId getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Food{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
