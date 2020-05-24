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
import shaart.application.calculator.dto.token.operator.MultiplyOperatorToken;
import shaart.application.calculator.dto.token.operator.SumOperatorToken;
import shaart.application.calculator.dto.token.value.ValueToken;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

  @InjectMocks
  private CalculatorServiceImpl calculatorService;

  @Test
  @DisplayName("Sum 2 values with right tokens' order")
  void calculateSumTwoValues() {
    final OperationToken left = new ValueToken(2.0);
    final OperationToken right = new ValueToken(2.0);
    final OperationToken plus = new SumOperatorToken();
    final List<OperationToken> operands = Arrays.asList(left, plus, right);

    Double result = calculatorService.calculate(operands);

    Assertions.assertEquals(4.0, result);
  }

  @Test
  @DisplayName("Multiply 2 values then add third")
  void calculateMultiplySumWithThreeValues() {
    final OperationToken first = new ValueToken(3.0);
    final OperationToken second = new ValueToken(1.0);
    final OperationToken third = new ValueToken(3.0);
    final OperationToken plus = new SumOperatorToken();
    final MultiplyOperatorToken multiply = new MultiplyOperatorToken();
    final List<OperationToken> operands = Arrays.asList(first, multiply, second, plus, third);

    Double result = calculatorService.calculate(operands);

    Assertions.assertEquals(6.0, result);
  }

  @Test
  @DisplayName("Sum 3 values with right tokens' order")
  void calculateSumThreeValues() {
    final OperationToken first = new ValueToken(1.0);
    final OperationToken second = new ValueToken(2.0);
    final OperationToken third = new ValueToken(3.0);
    final OperationToken plus = new SumOperatorToken();
    final List<OperationToken> operands = Arrays.asList(first, plus, second, plus, third);

    Double result = calculatorService.calculate(operands);

    Assertions.assertEquals(6.0, result);
  }
}