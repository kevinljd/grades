/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package grades;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppCurrentYear() {
        App classUnderTest = new App();
        assertEquals(2019, classUnderTest.getCurrentYear());
    }

    @Test public void testAppCurrentSem() {
        App classUnderTest = new App();
        assertEquals(2, classUnderTest.getCurrentSem());
    }
}
