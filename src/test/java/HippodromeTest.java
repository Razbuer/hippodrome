import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

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

    /**
     * Проверить, что при передаче в конструктор пустого списка, будет выброшено IllegalArgumentException;
     */
    @Test
    public void constructorShouldNotGetEmptyListAndShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList()));
    }

    /**
     * Проверить, что при передаче в конструктор пустого списка,
     * выброшенное исключение будет содержать сообщение "Horses cannot be empty.";
     */
    @Test
    public void constructorShouldNotGetEmptyListAndThrowShouldContainOurText() {
        try {
           new Hippodrome(new ArrayList());
        } catch (Exception e) {
            Assertions.assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    /**
     * Проверить, что метод возвращает список, который содержит те же объекты и в той же последовательности,
     * что и список который был передан в конструктор.
     * При создании объекта Hippodrome передай в конструктор список из 30 разных лошадей;
     */
    @Test
    public void getHorseShouldReturnCorrectList() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("TestHorse-" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        List<Horse> horsesFromHippodrome = hippodrome.getHorses();

        Assertions.assertArrayEquals(horses.toArray(), horsesFromHippodrome.toArray());
    }

    /**
     * Проверить, что метод вызывает метод move у всех лошадей.
     * При создании объекта Hippodrome передай в конструктор список из 50 моков лошадей и воспользуйся методом verify.
     */
    @Test
    public void moveShouldBeCalledInAllHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Horse mockHorse = Mockito.mock(Horse.class);
            horses.add(mockHorse);
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse hors : horses) {
            Mockito.verify(hors).move();
        }
    }

    /**
     * Проверить, что метод возвращает лошадь с самым большим значением distance.
     */
    @Test
    public void getWinnerShouldReturnHorseWithMaxDistance() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("TestHorse-" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        List<Horse> horsesFromHippodrome = hippodrome.getHorses();

        Horse winner = horsesFromHippodrome.stream().max(Comparator.comparing(Horse::getDistance)).get();

        Assertions.assertTrue(winner.equals(hippodrome.getWinner()));
    }
}
