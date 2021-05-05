import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AvancadoTest {

    private Avancado ronaldo;
    private Avancado messi;

    @BeforeEach
    void setUp() {

        ronaldo = new Avancado("Cristiano Ronaldo", 91, 90, 89, 87, 94, 96, 84, true,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        messi = new Avancado("Lionel Messi", 91, 84 , 85, 87, 77, 94, 90, true,
                new ArrayList<>(Arrays.asList("Barcelona")));
    }

    @Test
    void testEquals() {
        assertEquals(true, ronaldo.equals(ronaldo));
        assertEquals(false, messi.equals(ronaldo));
    }

    @Test
    void testClone() {
        assertEquals(true, ronaldo.equals(ronaldo.clone()));
        assertEquals(false, ronaldo.equals(messi.clone()));
    }

    @Test
    void testToString() {
        System.out.println(ronaldo.toString());
        System.out.println(messi.toString());
    }

    @Test
    void habilidade() {
    }
}