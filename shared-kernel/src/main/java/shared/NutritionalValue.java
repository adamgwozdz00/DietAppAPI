package shared;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class NutritionalValue {

  private BigDecimal nutritionalValue;

  protected NutritionalValue() {
  }

  public NutritionalValue(double nutritionalValue) {
    this.nutritionalValue = BigDecimal.valueOf(nutritionalValue);
  }

  public NutritionalValue(long nutritionalValue) {
    this.nutritionalValue = BigDecimal.valueOf(nutritionalValue);
  }

  public void add(NutritionalValue nutritionalValue) {
    this.nutritionalValue = this.nutritionalValue.add(nutritionalValue.nutritionalValue);
  }

  public void multiply(double multiple) {
    this.nutritionalValue = this.nutritionalValue.multiply(BigDecimal.valueOf(multiple));
  }

  public void multiply(NutritionalValue multiple) {
    this.nutritionalValue = this.nutritionalValue.multiply(multiple.nutritionalValue);
  }

  public void divide(NutritionalValue divisor) {
    this.nutritionalValue = this.nutritionalValue.divide(divisor.nutritionalValue);
  }

  public boolean compare(NutritionalValue nutritionalValue) {
    return this.nutritionalValue.compareTo(nutritionalValue.nutritionalValue) == 0;
  }

  public static NutritionalValue ZERO() {
    return new NutritionalValue(0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NutritionalValue)) {
      return false;
    }
    NutritionalValue that = (NutritionalValue) o;
    return this.nutritionalValue.equals(that.nutritionalValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nutritionalValue);
  }

  @Override
  public String toString() {
    return "NutritionalValue{" +
        "nutritionalValue=" + nutritionalValue +
        '}';
  }
}
