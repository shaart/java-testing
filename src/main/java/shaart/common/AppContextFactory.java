package shaart.common;

import shaart.application.calculator.CalculatorApplication;
import shaart.application.calculator.impl.CalculatorApplicationImpl;
import shaart.application.calculator.service.CalculatorService;
import shaart.application.calculator.service.OperationService;
import shaart.application.calculator.service.impl.CalculatorServiceImpl;
import shaart.application.calculator.service.impl.OperationServiceImpl;
import shaart.common.enums.ApplicationName;

public class AppContextFactory {

  public Application getApp(String appName) {
    final ApplicationName applicationName = ApplicationName.getAppByName(appName);

    if (applicationName == ApplicationName.CALCULATOR) {
      return calculator();
    }
    return null;
  }

  private CalculatorApplication calculator() {
    final OperationService operationService = operationService();

    return new CalculatorApplicationImpl(operationService, calculatorService());
  }

  private CalculatorService calculatorService() {
    return new CalculatorServiceImpl();
  }

  private OperationService operationService() {
    return new OperationServiceImpl();
  }

}
