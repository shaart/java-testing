package shaart.application.calculator.dto.token.value;

import lombok.RequiredArgsConstructor;
import shaart.application.calculator.dto.OperationToken;

@RequiredArgsConstructor
public class ValueToken implements OperationToken {

  private final Double value;

  @Override
  public Double evaluate(Double left, Double right) {
    throw new UnsupportedOperationException("Can't evaluate something on number");
  }

  @Override
  public Double getValue() {
    return value;
  }

  @Override
  public int order() {
    throw new UnsupportedOperationException("Number does not have any order");
  }

  public boolean isNumber() {
    return true;
  }
}
