package Tests;

import Model.Jogador;
import Model.Medio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedioTest {

    private Medio quim;
    private Medio rui;

    @BeforeEach
    void setUp() {

        quim = new Medio("Quim", 6, 91, 90, 89, 87, 94, 96, 84, Jogador.Estado.ENTRANDO, 40,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        rui = new Medio("Rui", 8, 91, 84 , 85, 87, 77, 94, 90, Jogador.Estado.ENTRANDO, 30,
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