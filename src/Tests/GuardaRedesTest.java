package Tests;

import Model.GuardaRedes;
import Model.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRedesTest {

    private GuardaRedes tone;
    private GuardaRedes zeca;

    @BeforeEach
    void setUp() {

        tone = new GuardaRedes("Tone", 1, 91, 90, 89, 87, 94, 96, 84, Jogador.Estado.SUPLENTE, 55,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        zeca = new GuardaRedes("Zeca", 1, 91, 84 , 85, 87, 77, 94, 90, Jogador.Estado.SAINDO, 67,
                new ArrayList<>(Arrays.asList("Barcelona")));
    }

    @Test
    void testEquals() {
        assertEquals(true, zeca.equals(zeca));
        assertEquals (false, zeca.equals(tone));
    }

    @Test
    void testClone() {
        assertEquals(true, zeca.equals(zeca.clone()));

    }

    @Test
    void testToString() {
        System.out.println(tone);
        System.out.println(zeca);
    }
}