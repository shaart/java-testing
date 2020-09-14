package shaart.application.calculator.dto.token.value;

import static org.mockito.ArgumentMatchers.anyDouble;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValueTokenTest {

    private static final double TOKEN_VALUE = 3.1;
    private ValueToken valueToken;

    @BeforeEach
    void initialization() {
        valueToken = new ValueToken(TOKEN_VALUE);
    }

    @Test
    @DisplayName("Value token getter return right value")
    void valueTokenGetterReturnRightValue() {
        Assertions.assertEquals(TOKEN_VALUE, valueToken.getValue());
    }

    @Test
    @DisplayName("Value can not be evolute")
    void valueCanNotBeEvolute() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> valueToken.evaluate(anyDouble(), anyDouble()));
    }
}
