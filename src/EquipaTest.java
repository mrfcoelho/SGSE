import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EquipaTest {

    private  Equipa madrid;
    private Jogador to;
    private Jogador ze;
    private Jogador ronaldo;
    private Jogador messi;

    @BeforeEach
    void setUp() {

        madrid = new Equipa("Real Madrid", new HashMap<Integer, Jogador>());
        to = new Defesa("To", 91, 90, 89, 87, 94, 96, 84, true,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        ze = new Defesa("Ze", 91, 84 , 85, 87, 77, 94, 90, true,
                new ArrayList<>(Arrays.asList("Barcelona")));
        madrid.adicionaJogador(to);
        madrid.adicionaJogador(ze);

        ronaldo = new Avancado("Cristiano Ronaldo", 91, 90, 89, 87, 94, 96, 84, true,
                new ArrayList<>(Arrays.asList("Sporting", "Manchester United", "Real Madrid", "Juventus")));

        messi = new Avancado("Lionel Messi", 91, 84 , 85, 87, 77, 94, 90, true,
                new ArrayList<>(Arrays.asList("Barcelona")));

        madrid.adicionaJogador(ronaldo);
        madrid.adicionaJogador(messi);
    }

    @Test
    void getJogadores() {
        System.out.println(madrid.getJogadores());
    }

    @Test
    void setJogadores() {
        madrid.setJogadores(new HashMap<>());
        madrid.adicionaJogador(to);
        System.out.println(madrid);

    }

    @Test
    void testEquals() {
        assertEquals(true, to.equals(to));
    }

    @Test
    void testToString() {
        System.out.println(madrid);
    }

    @Test
    void testClone() {
        System.out.println(madrid.clone());
        assertEquals(true, madrid.equals(madrid.clone()));
    }
}