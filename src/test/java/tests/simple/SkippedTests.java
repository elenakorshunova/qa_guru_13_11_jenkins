package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {
    @Test
    @Disabled
    void test1() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test2() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test3() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test4() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void test5() {
        assertTrue(true);
    }
}
