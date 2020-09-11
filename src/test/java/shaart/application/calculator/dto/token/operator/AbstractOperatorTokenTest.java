package shaart.application.calculator.dto.token.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AbstractOperatorTokenTest {

    @Spy
    private AbstractOperatorToken abstractOperatorToken;

    @Test
    @DisplayName("Abstract Operator Token is not number")
    void abstractOperatorTokenIsNotNumber () {
        Assertions.assertFalse(abstractOperatorToken.isNumber());
    }

    @Test
    @DisplayName("Try to get value throw Exception")
    void tryToGetValueThrowException (){
        Assertions.assertThrows(UnsupportedOperationException.class, () -> abstractOperatorToken.getValue());
    }
}
