import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class HorseTest {

    /**
     * Проверить, что при передаче в конструктор первым параметром null,
     * будет выброшено IllegalArgumentException.
     * Для этого нужно воспользоваться методом assertThrows;
     * */
    @Test
    public void firstParamOfConstructorShouldNotBeNullAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(null, 1.0, 1.0);});
    }

    /**
     * Проверить, что при передаче в конструктор первым параметром null,
     * выброшенное исключение будет содержать сообщение "Name cannot be null.".
     * Для этого нужно получить сообщение из перехваченного исключения и воспользоваться методом assertEquals;
     */
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

    /**
     * Проверить, что при передаче в конструктор первым параметром пустой строки
     * или строки содержащей только пробельные символы (пробел, табуляция и т.д.), будет выброшено IllegalArgumentException.
     * Чтобы выполнить проверку с разными вариантами пробельных символов, нужно сделать тест параметризованным;
     */
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    public void firstParamOfConstructorShouldNotBeEmptyAndShouldThrowException(String firstParam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse(firstParam, 1.0, 1.0);});
    }

    /**
     * Проверить, что при передаче в конструктор первым параметром пустой строки
     * или строки содержащей только пробельные символы (пробел, табуляция и т.д.),
     * выброшенное исключение будет содержать сообщение "Name cannot be blank.";
     */
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

    /**
     * Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
     * будет выброшено IllegalArgumentException;
     */
    @Test
    public void secondParamOfConstructorShouldNotBeNegativeAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse("TestName", -1.0, 1.0);});
    }

    /**
     * Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
     * выброшенное исключение будет содержать сообщение "Speed cannot be negative.";
     */
    @Test
    public void secondParamOfConstructorShouldNotBeNegativeAndThrowShouldContainOurText() {
        String textException = "";
        try {
            new Horse("TestName", -1.0, 1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Speed cannot be negative.", textException);
    }

    /**
     * Проверить, что при передаче в конструктор третьим параметром отрицательного числа,
     * будет выброшено IllegalArgumentException;
     */
    @Test
    public void thirdParamOfConstructorShouldNotBeNegativeAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Horse("TestName", 1.0, -1.0);});
    }

    /**
     * Проверить, что при передаче в конструктор третьим параметром отрицательного числа,
     * выброшенное исключение будет содержать сообщение "Distance cannot be negative.";
     */
    @Test
    public void thirdParamOfConstructorShouldNotBeNegativeAndThrowShouldContainOurText() {
        String textException = "";
        try {
            new Horse("TestName", 1.0, -1.0);
        } catch (IllegalArgumentException e) {
            textException = e.getMessage();
        }
        Assertions.assertEquals("Distance cannot be negative.", textException);
    }

    /**
     * Проверить, что метод возвращает строку, которая была передана первым параметром в конструктор;
     */
    @Test
    public void getNameShouldReturnStringFromConstructor() {
        String testName = "TestName";
        Horse horse = new Horse(testName, 1.0, 1.0);
        Assertions.assertEquals(testName, horse.getName());
    }

    /**
     * Проверить, что метод возвращает число, которое было передано вторым параметром в конструктор;
     */
    @Test
    public void getSpeedShouldReturnStringFromConstructor() {
        Double testSpeed = 1.0;
        Horse horse = new Horse("TestName", testSpeed, 1.0);
        Assertions.assertEquals(testSpeed, horse.getSpeed());
    }

    /**
     * Проверить, что метод возвращает число, которое было передано третьим параметром в конструктор;
     */
    @Test
    public void getDistanceShouldReturnStringFromConstructor() {
        Double testDistance = 1.0;
        Horse horse = new Horse("TestName", 1.0, testDistance);
        Assertions.assertEquals(testDistance, horse.getDistance());
    }

    /**
     * Проверить, что метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами;
     */
    @Test
    public void getDistanceShouldReturnZeroIfConstructorWasWithTwoParam() {
        Horse horse = new Horse("TestName", 1.0);
        Assertions.assertEquals(0, horse.getDistance());
    }


    /**
     * Проверить, что метод вызывает внутри метод getRandomDouble с параметрами 0.2 и 0.9.
     */
    @Test
    public void moveShouldCalledGetRandomDoubleWithCorrectParam() {
        try(MockedStatic<Horse> mockStaticHorse = Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("TestName", 1.0, 1.0);
            horse.move();
            mockStaticHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    /**
     * Проверить, что метод присваивает дистанции значение высчитанное по формуле: distance + speed * getRandomDouble(0.2, 0.9).
     * Для этого нужно замокать getRandomDouble, чтобы он возвращал определенные значения, которые нужно задать параметризовав тест.
     */
    @Test
    public void moveShouldCorrectCalculateDistance() {
        Horse horse = new Horse("TestName", 1.0, 1.0);

        try(MockedStatic<Horse> mockStaticHorse = Mockito.mockStatic(Horse.class)) {
            mockStaticHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.0);

            horse.move();
            Assertions.assertEquals(2.0, horse.getDistance());
        }
    }
}
