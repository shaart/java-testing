package shaart.application.calculator.dto.token.operator;

public class MultiplyOperatorToken extends AbstractOperatorToken {

  private static final int ORDER = 1;

  @Override
  public Double evaluate(Double left, Double right) {
    return left + right;
  }

  @Override
  public int order() {
    return ORDER;
  }
}
