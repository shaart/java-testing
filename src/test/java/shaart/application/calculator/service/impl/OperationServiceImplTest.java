package shaart.application.calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OperationServiceImplTest {

  @InjectMocks
  private OperationServiceImpl operationService;

  @Test
  @DisplayName("Splitting with two numbers and operator: plus")
  void splitByOperators() {
    String[] expectedTokens = {"1", "+", "2"};

    final String[] result = operationService.splitByOperators("1+2");

    assertArrayEquals(expectedTokens, result);
  }

  @Test
  @DisplayName("Splitting with all operators: plus, minus, multiply, divide")
  void splitByOperatorsWithAllOperators() {
    String[] expectedTokens = {"1", "+", "2", "/", "3", "*", "9", "-", "8"};

    final String[] result = operationService.splitByOperators("1+2/3*9-8");

    assertArrayEquals(expectedTokens, result);
  }
}