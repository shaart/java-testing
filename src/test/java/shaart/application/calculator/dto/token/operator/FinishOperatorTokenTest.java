package shaart.application.calculator.dto.token.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FinishOperatorTokenTest {

    FinishOperatorToken finishOperatorToken = new FinishOperatorToken();

    @Test
    @DisplayName("Evaluate return correct value for finish")
    void evaluateReturnCorrectValueForFinish () {
        final Double leftNumber = 2.2;
        final Double rightNumber = 4.0;

        Assertions.assertEquals(rightNumber, finishOperatorToken.evaluate(leftNumber, rightNumber));
    }
}
