import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HorseTest {

    @Test
    public void firstParamOfConstructorShouldNotBeNullAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(null, 1.0, 1.0);});
    }

    @Test
    public void firstParamOfConstructorShouldNotBeNullAndThrowShouldContainOurText() {
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
    public void firstParamOfConstructorShouldNotBeEmptyAndShouldThrowException(String firstParam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(firstParam, 1.0, 1.0);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    public void firstParamOfConstructorShouldNotBeEmptyAndThrowShouldContainOurText(String firstParam) {
        String textException = "";
        try {
            new Horse(firstParam, 1.0, 1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Name cannot be blank.", textException);
    }

    @Test
    public void secondParamOfConstructorShouldNotBeNegativeAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse("name", -1.0, 1.0);});
    }

    @Test
    public void secondParamOfConstructorShouldNotBeNegativeAndThrowShouldContainOurText() {
        String textException = "";
        try {
            new Horse("name", -1.0, 1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Speed cannot be negative.", textException);
    }

    @Test
    public void thirdParamOfConstructorShouldNotBeNegativeAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse("name", 1.0, -1.0);});
    }

    @Test
    public void thirdParamOfConstructorShouldNotBeNegativeAndThrowShouldContainOurText() {
        String textException = "";
        try {
            new Horse("name", 1.0, -1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Distance cannot be negative.", textException);
    }


}
