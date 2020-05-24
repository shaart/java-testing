package shaart.application.calculator.service.impl;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import shaart.application.calculator.dto.OperationToken;
import shaart.application.calculator.dto.token.operator.FinishOperatorToken;
import shaart.application.calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

  public static final FinishOperatorToken FINISH_OPERATOR_TOKEN = new FinishOperatorToken();

  @Override
  public Double calculate(List<OperationToken> expressionTokens) {
    Deque<Double> numbersStack = new LinkedList<>();
    Deque<OperationToken> operatorsStack = new LinkedList<>();

    for (OperationToken token : expressionTokens) {
      if (token.isNumber()) {
        numbersStack.push(token.getValue());
      } else {
        evaluateIfPossible(numbersStack, operatorsStack, token);
        operatorsStack.push(token);
      }
    }
    evaluateIfPossible(numbersStack, operatorsStack, FINISH_OPERATOR_TOKEN);
    Double result = numbersStack.pop();
    if (!numbersStack.isEmpty() || !operatorsStack.isEmpty()) {
      throw new IllegalStateException("Too many operands");
    }

    return result;
  }

  private void evaluateIfPossible(Deque<Double> numbersStack,
      Deque<OperationToken> operatorsStack, OperationToken token) {
    while (numbersStack.size() >= 2 && operatorsStack.size() >= 1) {
      final OperationToken lastOperation = operatorsStack.peekLast();
      if (lastOperation != null && lastOperation.order() > token.order()) {
        final Double right = numbersStack.pop();
        final Double left = numbersStack.pop();
        final OperationToken operation = operatorsStack.pop();

        Double tokenResult = operation.evaluate(left, right);
        numbersStack.push(tokenResult);
      } else {
        break;
      }
    }
  }

}
