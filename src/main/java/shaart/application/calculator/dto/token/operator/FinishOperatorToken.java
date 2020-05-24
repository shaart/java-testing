package shaart.application.calculator.dto.token.operator;

public class FinishOperatorToken extends AbstractOperatorToken {

  private static final int ORDER = Integer.MIN_VALUE;

  @Override
  public Double evaluate(Double left, Double right) {
    return right;
  }

  @Override
  public int order() {
    return ORDER;
  }
}
