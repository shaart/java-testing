package shaart.application.calculator.dto.token.operator;

import shaart.application.calculator.dto.OperationToken;

public abstract class AbstractOperatorToken implements OperationToken {

  @Override
  public boolean isNumber() {
    return false;
  }

  public abstract Double evaluate(Double left, Double right);

  @Override
  public Double getValue() {
    throw new UnsupportedOperationException("Can't get value of operand");
  }
}
