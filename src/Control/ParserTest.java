package Control;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parse() {
        Parser.parse();
    }

    @Test
    void lerFicheiro() {
        List<String> lines = Parser.lerFicheiro("Input/logs.txt");
        System.out.println(lines);
    }
}