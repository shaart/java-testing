package shaart.application.calculator.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import shaart.application.calculator.dto.OperationToken;
import shaart.application.calculator.dto.token.operation.SumOperationToken;
import shaart.application.calculator.dto.token.value.ValueToken;
import shaart.application.calculator.service.OperationService;

public class OperationServiceImpl implements OperationService {

  public static final SumOperationToken SUM_OPERATION_TOKEN = new SumOperationToken();
  public static final String OPERATOR_REGEX = "[+\\-*/]";
  public static final String OPERATORS_REGEX_WITH_DELIMITER_SAVING =
      "((?<=" + OPERATOR_REGEX + ")|(?=" + OPERATOR_REGEX + "))";

  @Override
  public List<OperationToken> getOperation(String fullOperation) {
    final String[] split = splitByOperators(fullOperation);
    return Stream.of(split)
        .map(this::toToken)
        .collect(Collectors.toList());
  }

  public String[] splitByOperators(String expression) {
    return expression.split(OPERATORS_REGEX_WITH_DELIMITER_SAVING);
  }

  private OperationToken toToken(String token) {
    if (isNumber(token)) {
      final double doubleValue = Double.parseDouble(token);
      return new ValueToken(doubleValue);
    }
    if ("+".equals(token)) {
      return SUM_OPERATION_TOKEN;
    }
    throw new UnsupportedOperationException("Operation '" + token + "' is not supported");
  }

  private boolean isNumber(String token) {
    try {
      Double.parseDouble(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public void requireValidTokens(List<OperationToken> operationTokens) {
    final Map<Boolean, List<OperationToken>> isNumberMap = operationTokens.stream()
        .collect(Collectors.groupingBy(OperationToken::isNumber));

    final List<OperationToken> numbersList = isNumberMap.get(Boolean.TRUE);
    final List<OperationToken> operatorsList = isNumberMap.get(Boolean.FALSE);

    final int numbersCount = numbersList.size();
    final int operatorsCount = operatorsList.size();

    if (numbersCount == 0 || operatorsCount == 0 || numbersCount == 1) {
      throw new IllegalArgumentException(
          String.format("Not enough numbers or operators. Got: numbers = %d; operators = %d",
              numbersCount, operatorsCount));
    }

    if (numbersCount != operatorsCount + 1) {
      throw new IllegalArgumentException(
          String.format("Numbers count must be equals to operators count + 1. "
              + "Got: numbers = %d; operators = %d", numbersCount, operatorsCount));
    }
  }
}
