package shaart.application.calculator.dto;

public interface OperationToken {

  boolean isNumber();

  Double evaluate(Double left, Double right);

  Double getValue();
}
