package shaart.application.calculator.dto.token.operator;

public class SumOperatorToken extends AbstractOperatorToken {

  @Override
  public Double evaluate(Double left, Double right) {
    return left + right;
  }
}
