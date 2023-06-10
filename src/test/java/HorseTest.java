import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t"})
    void throwExceptionWhenIncorrectName(String incorrectOptions) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(incorrectOptions, 0, 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t"})
    void checkExceptionMessageWhenIncorrectName(String incorrectOptions) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(incorrectOptions, 0, 0));
        assertEquals("Name cannot be blank.", exception.getMessage());
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