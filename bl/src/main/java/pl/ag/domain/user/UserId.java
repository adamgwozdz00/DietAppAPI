package pl.ag.domain.user;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable {

  private long userId;

  protected UserId() {
  }

  UserId(long userId) {
    this.userId = userId;
  }

  public static UserId userId(long userId) {
    return new UserId(userId);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserId)) {
      return false;
    }
    UserId that = (UserId) o;
    return this.userId == that.userId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }

  public long getUserId() {
    return userId;
  }
}

