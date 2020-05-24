package shaart.application.calculator.dto;

public interface OperationToken {

  boolean isNumber();

  Double evaluate(Double left, Double right);

  Double getValue();

  /**
   * Order of operation. Bigger number means maximum order.
   *
   * @return order's number;
   */
  int order();
}
