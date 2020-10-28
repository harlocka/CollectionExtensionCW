import org.junit.Test;
import static org.junit.Assert.*;

public class OptimizedLogTests
{
    private OptimizedLog<String> log = new OptimizedLog<>();

    @Test
    public void testAdd() {
        log.add("Hello world!");
        assertTrue(log.contains("Hello World!"));
    }

    @Test
    public void testSize() {
        log.add("Hello world!");
        log.add("QWERTY");
        log.add("Password");
        log.remove(2);
        assertEquals(2, log.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(log.isEmpty());
    }
}
