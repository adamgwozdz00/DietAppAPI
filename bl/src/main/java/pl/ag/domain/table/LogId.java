package pl.ag.domain.table;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class LogId implements Serializable {

  private Long logId;

  protected LogId() {
  }

  LogId(long logId) {
    this.logId = logId;
  }

  public static LogId logId(long logId) {
    return new LogId(logId);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LogId)) {
      return false;
    }
    LogId logId1 = (LogId) o;
    return logId == logId1.logId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(logId);
  }

  public Long getLogId() {
    return logId;
  }
}
