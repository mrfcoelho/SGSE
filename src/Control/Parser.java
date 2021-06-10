package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.*;
import jdk.swing.interop.SwingInterOpUtils;

public class Parser {
    public static void parse(IModel model) throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("Input/logs.txt");
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        List<Jogo> jogos = new ArrayList<>();
        Equipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            //?System.out.println(linha);
            //?System.out.println(jogadores);
            //?System.out.println(equipas);
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    jogadores.put(j.getId(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    j.atualizaHistorial(ultima.getNome());
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getId(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    j.atualizaHistorial(ultima.getNome());
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getId(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    j.atualizaHistorial(ultima.getNome());
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getId(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    j.atualizaHistorial(ultima.getNome());
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getId(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    j.atualizaHistorial(ultima.getNome());
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();
            }
            model.setJogadores(jogadores);
            model.setEquipas(equipas);
            model.setJogos(jogos);
        }

        //debug
        /*
        for (Equipa e : equipas.values()) {
            System.out.println(e.toString());
        }
        for (Jogo jog : jogos) {
            System.out.println(jog.toString());
        }
         */
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
