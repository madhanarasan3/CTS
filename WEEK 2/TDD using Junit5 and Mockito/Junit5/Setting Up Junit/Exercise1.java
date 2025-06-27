package javasample;
import org.junit.Test;
import static org.junit.Assert.*;
public class Excerise1{
        @Test
        public void testAddition() {
        int result = 2 + 3;
        System.out.println("The result is: " + result);  // This will show in the console
        assertEquals(5, result);
    }
}
