package pl.ag.shared;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


public class AggregateId implements Serializable {

  private final String aggregateId;

  public AggregateId(String aggregateId) {
    if (aggregateId == null) {
      throw new IllegalArgumentException("Id cannot be null");
    }
    this.aggregateId = aggregateId;
  }

  public static AggregateId generate() {
    return new AggregateId(UUID.randomUUID().toString());
  }

  public String getAggregateId() {
    return aggregateId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AggregateId)) {
      return false;
    }
    AggregateId other = (AggregateId) o;
    if (aggregateId == null) {
      if (other.aggregateId != null) {
        return false;
      }
    }
    return aggregateId.equals(other.aggregateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregateId);
  }

  @Override
  public String toString() {
    return aggregateId;
  }
}
