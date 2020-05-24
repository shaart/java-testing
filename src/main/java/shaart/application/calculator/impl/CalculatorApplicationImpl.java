package shaart.application.calculator.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shaart.application.calculator.CalculatorApplication;
import shaart.application.calculator.dto.OperationToken;
import shaart.application.calculator.service.CalculatorService;
import shaart.application.calculator.service.OperationService;

@Slf4j
@RequiredArgsConstructor
public class CalculatorApplicationImpl implements CalculatorApplication {

  private final OperationService operationService;
  private final CalculatorService calculatorService;

  @Override
  public void run(String... args) {
    final String fullOperation = String.join("", args);
    List<OperationToken> operationTokens = operationService.getOperation(fullOperation);
    operationService.requireValidTokens(operationTokens);

    Double result = calculatorService.calculate(operationTokens);

    log.info("Result is: {}", result);
  }
}
