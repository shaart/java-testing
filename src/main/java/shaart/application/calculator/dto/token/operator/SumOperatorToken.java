package shaart.application.calculator.dto.token.operator;

public class SumOperatorToken extends AbstractOperatorToken {

  private static final int ORDER = 2;

  @Override
  public Double evaluate(Double left, Double right) {
    return left * right;
  }

  @Override
  public int order() {
    return ORDER;
  }
}
