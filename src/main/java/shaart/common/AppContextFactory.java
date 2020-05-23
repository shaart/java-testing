package shaart.common;

import shaart.calculator.Calculator;
import shaart.calculator.impl.CalculatorImpl;

public class AppContextFactory {

  public Application getApp(String appName) {
    final ApplicationName applicationName = ApplicationName.getAppByName(appName);

    if (applicationName == ApplicationName.CALCULATOR) {
      return calculator();
    }
    return null;
  }

  private Calculator calculator() {
    return new CalculatorImpl();
  }
}
