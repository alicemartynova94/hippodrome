import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {

    @Test
    void throwExceptionWhenConstructorIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void checkExceptionMessageWhenConstructorIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void throwExceptionWhenConstructorListEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    void checkExceptionMessageWhenConstructorListEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horsesList = List.of(
                new Horse("A", 10, 100),
                new Horse("B", 20, 200),
                new Horse("C", 30, 300),
                new Horse("D", 40, 400),
                new Horse("E", 50, 500),
                new Horse("F", 60, 600),
                new Horse("G", 70, 700),
                new Horse("H", 80, 800),
                new Horse("I", 90, 900),
                new Horse("J", 100, 1000),
                new Horse("K", 110, 1100),
                new Horse("L", 120, 1200),
                new Horse("M", 130, 1300),
                new Horse("N", 140, 1400),
                new Horse("O", 150, 1500),
                new Horse("P", 160, 1600),
                new Horse("Q", 170, 1700),
                new Horse("R", 180, 1800),
                new Horse("S", 190, 1900),
                new Horse("T", 200, 2000),
                new Horse("U", 210, 2100),
                new Horse("V", 220, 2200),
                new Horse("W", 230, 2300),
                new Horse("X", 240, 2400),
                new Horse("Y", 250, 2500),
                new Horse("Z", 260, 2600),
                new Horse("AA", 270, 2700),
                new Horse("AB", 280, 2800),
                new Horse("AC", 290, 2900),
                new Horse("AD", 300, 3000));
        Hippodrome hippodrome = new Hippodrome(horsesList);
        assertEquals(horsesList, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horsesList = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            horsesList.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horsesList);
        hippodrome.move();
        for (Horse horse : horsesList) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("A", 10, 100);
        Horse horse2 = new Horse("B", 20, 200);
        List<Horse> horseList = new ArrayList<>(List.of(horse1, horse2));
        Hippodrome hippodrome = new Hippodrome(horseList);
        assertEquals(horse2, hippodrome.getWinner());
    }
}