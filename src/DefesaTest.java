import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DefesaTest {

    private Defesa to;
    private Defesa ze;

    @BeforeEach
    void setUp() {

        to = new Defesa("To", 91, 90, 89, 87, 94, 96, 84, true,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        ze = new Defesa("Ze", 91, 84 , 85, 87, 77, 94, 90, true,
                new ArrayList<>(Arrays.asList("Barcelona")));
    }
    @Test
    void testEquals() {
        assertEquals(true, ze.equals(ze));
        assertEquals(false, ze.equals(to));
    }

    @Test
    void testClone() {
        assertEquals (true, ze.equals(ze.clone()));
    }

    @Test
    void testToString() {
        System.out.println(to);
        System.out.println(ze);
    }
}