package shaart.application.calculator.service;

import java.util.List;
import shaart.application.calculator.dto.OperationToken;

public interface OperationService {

  List<OperationToken> getOperation(String fullOperation);

  void requireValidTokens(List<OperationToken> operationTokens);
}
