package shaart.application.calculator.impl;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import shaart.application.calculator.service.CalculatorService;
import shaart.application.calculator.service.OperationService;
import shaart.test.common.HolderDto;

@ExtendWith(MockitoExtension.class)
class CalculatorApplicationImplTest {

  @Mock
  private OperationService operationService;

  @Mock
  private CalculatorService calculatorService;

  @InjectMocks
  private CalculatorApplicationImpl calculatorApplication;

  @Test
  @DisplayName("Running app has a right services calling order")
  void runHasRightCallsOrder() {
    HolderDto<Boolean> hasValidationCalled = new HolderDto<>(false);
    HolderDto<Boolean> hasTokensDeterminationCalled = new HolderDto<>(false);
    HolderDto<Boolean> hasCalculationCalled = new HolderDto<>(false);
    final String fullOperation = "1+2";
    final String[] args = {"1", "+", "2"};

    final Answer<Object> makeTokensCalled = invocationOnMock -> {
      hasTokensDeterminationCalled.setValue(true);
      return null;
    };
    when(operationService.getOperation(fullOperation))
        .then(makeTokensCalled);

    final Answer<Void> checkTokensDeterminationCalled = invocationOnMock -> {
      if (!hasTokensDeterminationCalled.getValue()) {
        throw new IllegalStateException(
            "Wrong calls order: validation must be called after tokens determining");
      }
      hasValidationCalled.setValue(true);
      return null;
    };
    doAnswer(checkTokensDeterminationCalled)
        .when(operationService).requireValidTokens(anyList());

    final Answer<Object> checkDeterminationAndValidationCalled = invocationOnMock -> {
      if (!hasValidationCalled.getValue() || !hasTokensDeterminationCalled.getValue()) {
        throw new IllegalStateException(
            "Wrong calls order: calculator must be called after tokens determining and their validation");
      }
      hasCalculationCalled.setValue(true);
      return 3.0;
    };
    when(calculatorService.calculate(anyList()))
        .then(checkDeterminationAndValidationCalled);

    calculatorApplication.run(args);
  }
}