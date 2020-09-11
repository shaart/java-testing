package shaart.application.calculator.dto.token.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MultiplyOperatorTokenTest {

    MultiplyOperatorToken multiplyOperatorToken = new MultiplyOperatorToken();

    @Test
    @DisplayName("Evaluate return correct value for multiply")
    void evaluateReturnCorrectValueForMultiply () {
        final Double leftNumber = 2.2;
        final Double rightNumber = 4.0;
        final Double correctResult = leftNumber * rightNumber;

        Assertions.assertEquals(correctResult, multiplyOperatorToken.evaluate(leftNumber, rightNumber));
    }
}
