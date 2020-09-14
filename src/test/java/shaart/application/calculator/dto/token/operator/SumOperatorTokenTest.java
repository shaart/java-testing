package shaart.application.calculator.dto.token.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumOperatorTokenTest {

    private SumOperatorToken sumOperatorToken;

    @BeforeEach
    void initialization() {
        sumOperatorToken = new SumOperatorToken();
    }

    @Test
    @DisplayName("Evaluate return correct value for sum")
    void evaluateReturnCorrectValueForSum () {
        final Double leftNumber = 2.2;
        final Double rightNumber = 4.0;
        final Double correctResult = leftNumber + rightNumber;
        Double evaluateResult;

        evaluateResult = sumOperatorToken.evaluate(leftNumber, rightNumber);

        Assertions.assertEquals(correctResult, evaluateResult);
    }
}
