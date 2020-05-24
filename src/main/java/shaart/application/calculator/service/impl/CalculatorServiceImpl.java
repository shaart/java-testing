package shaart.application.calculator.service.impl;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import shaart.application.calculator.dto.OperationToken;
import shaart.application.calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public Double calculate(List<OperationToken> expressionTokens) {
    Deque<Double> numbersStack = new LinkedList<>();
    Deque<OperationToken> operatorsStack = new LinkedList<>();

    for (OperationToken token : expressionTokens) {
      if (token.isNumber()) {
        numbersStack.push(token.getValue());
        evaluateIfPossible(numbersStack, operatorsStack);
      } else {
        operatorsStack.push(token);
      }
    }
    Double result = numbersStack.pop();
    if (!numbersStack.isEmpty() || !operatorsStack.isEmpty()) {
      throw new IllegalStateException("Too many operands");
    }

    return result;
  }

  private void evaluateIfPossible(Deque<Double> numbersStack,
      Deque<OperationToken> operatorsStack) {
    while (numbersStack.size() >= 2 && operatorsStack.size() >= 1) {
      final Double right = numbersStack.pop();
      final Double left = numbersStack.pop();
      final OperationToken operation = operatorsStack.pop();

      Double tokenResult = operation.evaluate(left, right);
      numbersStack.push(tokenResult);
    }
  }

}
