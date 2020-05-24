package shaart.application.calculator.dto.token.operation;

import shaart.application.calculator.dto.OperationToken;

public class SumOperationToken implements OperationToken {

  @Override
  public boolean isNumber() {
    return false;
  }

  @Override
  public Double evaluate(Double left, Double right) {
    return left + right;
  }

  @Override
  public Double getValue() {
    throw new UnsupportedOperationException("Can't get value of operand");
  }
}
