package shaart.application.calculator.service.impl;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import shaart.application.calculator.dto.OperationToken;
import shaart.application.calculator.dto.token.operation.SumOperationToken;
import shaart.application.calculator.dto.token.value.ValueToken;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

  @InjectMocks
  private CalculatorServiceImpl calculatorService;

  @Test
  @DisplayName("Sum 2 values with right tokens' order")
  void calculateSumTwoValues() {
    final ValueToken left = new ValueToken(1.0);
    final ValueToken right = new ValueToken(2.5);
    final SumOperationToken plus = new SumOperationToken();
    final List<OperationToken> operands = Arrays.asList(left, plus, right);

    Double result = calculatorService.calculate(operands);

    Assertions.assertEquals(3.5, result);
  }

  @Test
  @DisplayName("Sum 3 values with right tokens' order")
  void calculateSumThreeValues() {
    final ValueToken first = new ValueToken(1.0);
    final ValueToken second = new ValueToken(2.5);
    final ValueToken third = new ValueToken(0.5);
    final SumOperationToken plus = new SumOperationToken();
    final List<OperationToken> operands = Arrays.asList(first, plus, second, plus, third);

    Double result = calculatorService.calculate(operands);

    Assertions.assertEquals(4.0, result);
  }
}