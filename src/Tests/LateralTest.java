package Tests;

import Model.Jogador;
import Model.Lateral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LateralTest {

    private Lateral quim;
    private Lateral rui;

    @BeforeEach
    void setUp() {

        quim = new Lateral("Quim", 91, 90, 89, 87, 94, 96, 84, 30, Jogador.Estado.SUPLENTE, 50,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        rui = new Lateral("Rui", 91, 84 , 85, 87, 77, 94, 90, 10, Jogador.Estado.SAINDO, 30,
                new ArrayList<>(Arrays.asList("Barcelona")));
    }

    @Test
    void testEquals() {
        assertEquals(true, quim.equals(quim));
        assertEquals(false, quim.equals(rui));
    }

    @Test
    void testClone() {
        assertEquals(true, quim.equals(quim.clone()));
        assertEquals(true, rui.equals(rui.clone()));
    }

    @Test
    void testToString() {
        System.out.println(quim);
        System.out.println(rui);
    }
}