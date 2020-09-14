package shaart.application.calculator.dto.token.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import shaart.application.calculator.dto.token.value.ValueToken;

@ExtendWith(MockitoExtension.class)
public class FinishOperatorTokenTest {

    private FinishOperatorToken finishOperatorToken;

    @BeforeEach
    void initialization() {
        finishOperatorToken = new FinishOperatorToken();
    }

    @Test
    @DisplayName("Evaluate return correct value for finish")
    void evaluateReturnCorrectValueForFinish () {
        final Double leftNumber = 2.2;
        final Double rightNumber = 4.0;
        Double evaluateResult;

        evaluateResult = finishOperatorToken.evaluate(leftNumber, rightNumber);

        Assertions.assertEquals(rightNumber, evaluateResult);
    }
}
