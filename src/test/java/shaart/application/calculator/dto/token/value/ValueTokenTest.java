package shaart.application.calculator.dto.token.value;

import static org.mockito.ArgumentMatchers.anyDouble;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValueTokenTest {

    private final double tokenValue = 3.1;
    private ValueToken valueToken = new ValueToken(tokenValue);

    @Test
    @DisplayName("Value token getter return right value")
    void valueTokenGetterReturnRightValue() {
        Assertions.assertEquals(tokenValue, valueToken.getValue());
    }

    @Test
    @DisplayName("Value can not be evolute")
    void valueCanNotBeEvolute() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> valueToken.evaluate(anyDouble(), anyDouble()));
    }
}
