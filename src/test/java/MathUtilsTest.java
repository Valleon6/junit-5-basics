import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Nested
    class addTest {
        @Test
        @DisplayName("Testing add method for + ")
        void testPositiveNumberAdd() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "The add method should add two numbers");

        }

        @Test
        @DisplayName("Testing add method for -")
        void testNegativeNumberAdd() {
            assertEquals(-2, mathUtils.add(-1, -1), "The add method should add two numbers");

        }
    }


    @Test
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
    }

    @Test
    void subtract() {
    }

    @Test
    @DisplayName("Multiply method")
    void multiply() {

        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2), "should return the product"),
                () -> assertEquals(4, mathUtils.add(2, 2), "This adds"),
                () -> assertEquals(1, mathUtils.divide(7, 7), "this should multiply"),
                () -> assertEquals(0, mathUtils.subtract(2, 2), "This subtracts")

        );
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void divide() {
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by 0. Should throw exception.");

    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up...");
    }

    @BeforeAll
    static void beforeInit() {
        System.out.println("This needs to run before all methods.");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. should not run ")
    void testDisabled() {
        fail("This test should be disabled");
    }
}