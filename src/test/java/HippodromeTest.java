import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HippodromeTest {

    /**
     * Проверить, что при передаче в конструктор null, будет выброшено IllegalArgumentException;
     * */
    @Test
    public void paramOfConstructorShouldNotBeNullAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    /**
     * Проверить, что при передаче в конструктор первым параметром null,
     * выброшенное исключение будет содержать сообщение "Name cannot be null.".
     * Для этого нужно получить сообщение из перехваченного исключения и воспользоваться методом assertEquals;
     */
    @Test
    public void paramOfConstructorShouldNotBeNullAndThrowShouldContainOurText() {
        try {
            new Hippodrome(null);
        } catch (Exception e) {
            Assertions.assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

}
