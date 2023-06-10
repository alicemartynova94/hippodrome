import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void throwExceptionWhenNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0, 0));
    }

    @Test
    void checkExceptionMessageWhenNameIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0, 0));
        assertEquals("Name cannot be null.", exception.getMessage());
    }
    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}