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
        List<Horse> horsesList = new ArrayList<>(30);
        horsesList.add(new Horse("A", 10, 100));
        horsesList.add(new Horse("B", 20, 200));
        horsesList.add(new Horse("C", 30, 300));
        horsesList.add(new Horse("D", 40, 400));
        horsesList.add(new Horse("E", 50, 500));
        horsesList.add(new Horse("F", 60, 600));
        horsesList.add(new Horse("G", 70, 700));
        horsesList.add(new Horse("H", 80, 800));
        horsesList.add(new Horse("I", 90, 900));
        horsesList.add(new Horse("J", 100, 1000));
        horsesList.add(new Horse("K", 110, 1100));
        horsesList.add(new Horse("L", 120, 1200));
        horsesList.add(new Horse("M", 130, 1300));
        horsesList.add(new Horse("N", 140, 1400));
        horsesList.add(new Horse("O", 150, 1500));
        horsesList.add(new Horse("P", 160, 1600));
        horsesList.add(new Horse("Q", 170, 1700));
        horsesList.add(new Horse("R", 180, 1800));
        horsesList.add(new Horse("S", 190, 1900));
        horsesList.add(new Horse("T", 200, 2000));
        horsesList.add(new Horse("U", 210, 2100));
        horsesList.add(new Horse("V", 220, 2200));
        horsesList.add(new Horse("W", 230, 2300));
        horsesList.add(new Horse("X", 240, 2400));
        horsesList.add(new Horse("Y", 250, 2500));
        horsesList.add(new Horse("Z", 260, 2600));
        horsesList.add(new Horse("AA", 270, 2700));
        horsesList.add(new Horse("AB", 280, 2800));
        horsesList.add(new Horse("AC", 290, 2900));
        horsesList.add(new Horse("AD", 300, 3000));
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