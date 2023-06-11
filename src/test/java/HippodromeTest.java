import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
   
    void getHorses() {
    }


    void move() {
    }


    void getWinner() {
    }
}