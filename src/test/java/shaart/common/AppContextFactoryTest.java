package shaart.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shaart.application.calculator.CalculatorApplication;

public class AppContextFactoryTest {

    private AppContextFactory appContextFactory;

    @BeforeEach
    void initialization() {
        appContextFactory = new AppContextFactory();
    }

    @Test
    @DisplayName("Calculator app may be getting by name")
    void calculatorAppMayBeGettingByName() {
        final String appName = "calculator";
        Application calculator;
        boolean isAppCalculator;

        try {
            calculator = appContextFactory.getApp(appName);
            isAppCalculator = calculator instanceof CalculatorApplication;

            Assertions.assertTrue(
                    isAppCalculator,
                    "Received application object isn't matches from " + CalculatorApplication.class.toString()
            );
        }
        catch (Exception exception) {
            Assertions.fail(exception.toString() + " was throwing, but no exceptions expected", exception);
        }
    }
}
