import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HorseTest {
    private static Horse HORSE_WITH_THREE_PARAM;
    private static Horse HORSE_WITH_TWO_PARAM;

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
    void throwExceptionWhenSpeedIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Some Name", -46, 0));
    }

    @Test
    void checkExceptionMessageWhenSpeedIsNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Some Name", -46, 0));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void throwExceptionWhenDistanceIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Some Name", 1, -78));
    }

    @Test
    void checkExceptionMessageWhenDistanceIsNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Some Name", 0, -78));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @BeforeAll
    static void initHorseWithThreeParam() {
        HORSE_WITH_THREE_PARAM = new Horse("Some name", 10, 30);
    }

    @BeforeAll
    static void initHorseWithTwoParam() {
        HORSE_WITH_TWO_PARAM = new Horse("Some name", 10);
    }

    @Test
    void getName() {
        String expectedName = "Some name";
        assertEquals(expectedName, HORSE_WITH_THREE_PARAM.getName());
    }

    @Test
    void getSpeed() {
        int expectedSpeed = 10;
        assertEquals(expectedSpeed, HORSE_WITH_THREE_PARAM.getSpeed());
    }

    @Test
    void getDistance() {
        int expectedDistance = 30;
        assertEquals(expectedDistance, HORSE_WITH_THREE_PARAM.getDistance());
    }

    @Test
    void getDistanceWhenNotSpecified() {
        int expectedDistance = 0;
        assertEquals(expectedDistance, HORSE_WITH_TWO_PARAM.getDistance());
    }

    @Test
    void moveMethodCallsGetRandomDouble() {
        try (MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            HORSE_WITH_THREE_PARAM.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

}