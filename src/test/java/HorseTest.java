import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HorseTest {

    @Test
    public void firstParamShouldNotBeNullAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(null, 1.0, 1.0);});
    }

    @Test
    public void firstParamShouldNotBeNullAndThrowShouldContainOurText() {
        String textException = "";
        try {
            new Horse(null, 1.0, 1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Name cannot be null.", textException);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    public void firstParamShouldNotBeEmptyAndShouldThrowException(String firstParam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(firstParam, 1.0, 1.0);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    public void firstParamShouldNotBeEmptyAndThrowShouldContainOurText(String firstParam) {
        String textException = "";
        try {
            new Horse(firstParam, 1.0, 1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Name cannot be blank.", textException);

    }
}
