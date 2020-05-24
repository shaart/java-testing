package shaart.application.calculator.service;

import java.util.List;
import shaart.application.calculator.dto.OperationToken;

public interface CalculatorService {

  Double calculate(List<OperationToken> operationTokens);
}
