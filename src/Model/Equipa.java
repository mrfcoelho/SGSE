package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Equipa.
 * @author grupo21
 * @version 1.0
 */
public class Equipa {
    //variaveis de instancia
    private String nome;
    private Map<Integer,Jogador> jogadores;

    //variaveis de class

    /**
     * Construtor vazio para a classe Equipa.
     */
    public Equipa(){
        this.nome = "";
        this.jogadores = new HashMap<>();
    }

    /**
     * Construtor parametrizado para a classe Equipa.
     * @param nome nome da equipa.
     * @param jogadores jogadores da equipa.
     */
    public Equipa (String nome, Map<Integer, Jogador> jogadores) {
        this.nome = nome;
        this.jogadores = new HashMap<>();

        for (Jogador j: jogadores.values()) {

            this.jogadores.put(j.getId(), j.clone());
        }

    }

    /**
     * Construtor copia para a classe Equipa.
     * @param newEquipa uma instancia da classe Equipa.
     */
    public Equipa (Equipa newEquipa){
        this.nome = newEquipa.getNome();
        this.jogadores = newEquipa.getJogadores();
    }

    //getters e setters
    /**
     * Metodo getter para a variavel de instancia nome da classe Equipa.
     * @return String com o nome da equipa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo setter para a variavel de instancia nome da classe Equipa.
     * @param nome String com o nome da equipa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo getter para a variavel de instancia jogadores da classe Equipa.
     * @return map com os jogadores de uma equipa.
     */
    public Map<Integer, Jogador> getJogadores() {
        Map<Integer,Jogador> resultado = new HashMap<>();
        for(Map.Entry<Integer,Jogador> e : jogadores.entrySet()){
            resultado.put(e.getKey(),e.getValue().clone());
        }
        return resultado;
    }

    /**
     * Metodo setter para a variavel jogadores da classe Equipa.
     * @param newJogadores map com os jogadores de uma equipa.
     */
    public void setJogadores(Map<Integer,Jogador> newJogadores){
        this.jogadores = new HashMap<>();
        for(Map.Entry<Integer,Jogador> e : newJogadores.entrySet()){
            this.jogadores.put(e.getKey(),e.getValue().clone());
        }
    }

    @Override
    /**
     * Metodo equals para a classe Equipa.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Equipa resultado = (Equipa)o;
        return this.nome.equals(resultado.getNome()) &&
                this.jogadores.equals(resultado.getJogadores());
    }

    @Override
    /**
     * Metodo toString para a classe Equipa.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Equipa:").append(this.nome).append("\n");
        for(Map.Entry<Integer,Jogador> e : this.jogadores.entrySet()){
            sb.append(e.getValue().toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    /**
     * Metodo clone para a classe Equipa.
     */
    public Equipa clone(){
        return new Equipa(this);
    }

    /**
     * Metodo que determina a habilidade de uma equipa, consoante as habilidades de cada jogador.
     * @return
     */
    public double habilidade(){
        return 0;
    }

    /**
     * Metodo que adiciona um jogador a uma equipa.
     * @param j um jogador a adicionar a equipa.
     */
    public void insereJogador(Jogador j) {

        this.jogadores.put(j.getId(), j.clone());

    }

    /**
     * Metodo que faz o parse de uma equipa.
     * @param input String com uma equipa em modo de texto.
     * @return uma equipa.
     */
    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0],
                new HashMap<>());
    }
}
