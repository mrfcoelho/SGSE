import java.util.HashMap;
import java.util.Map;

/**
 * Classe que modela uma equipa.
 * @author grupo21
 * @version 1.0
 */
public class Equipa {

    private static int numEquipas; // numero de equipas que foram criadas.
    private String nome;
    private int numero;
    private Map<Integer,Jogador> jogadores;

    /**
     * Construtor vazio para a classe Equipa.
     */
    public Equipa(){
        this.numEquipas++;
        this.numero = numEquipas;
        this.nome = "";
        this.jogadores = new HashMap<>();
    }

    /**
     * Construtor parametrizado para a classe Equipa.
     * @param nome nome da equipa.
     * @param jogadores jogadores da equipa.
     */
    public Equipa (String nome, Map<Integer, Jogador> jogadores) {
        this.numEquipas++;
        this.numero = numEquipas;
        this.nome = nome;
        this.jogadores = new HashMap<>();

        for (Jogador j: jogadores.values()) {

            this.jogadores.put(j.getNumero(), j.clone());
        }

    }

    /**
     * Construto copia para a classe Equipa.
     * @param newEquipa uma instancia da classe Equipa.
     */
    public Equipa (Equipa newEquipa){
        this.nome = newEquipa.getNome();
        this.numero = newEquipa.getNumero();
        this.setJogadores(newEquipa.getJogadores());
    }

    /**
     * Metodo getter para a variavel de instancia numEquipas da classe Equipa.
     * @return int com o valor do numero de equipas ja criadas.
     */
    public static int getNumEquipas() {
        return numEquipas;
    }

    /**
     * Metodo setter para a variavel de instancia numEquipas da classe Equipa.
     * @param numEquipas int com o numero de equipas ja criadas.
     */
    public static void setNumEquipas(int numEquipas) {
        Equipa.numEquipas = numEquipas;
    }

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
     * Metodo getter para a variavel de instancia numero da classe Equipa.
     * @return numero da equipa.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo getter para a variavel de instancia numero da classe Equipa.
     * @param numero numero de uma equipa.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo getter para a variavel de instancia jogadores da classe Equipa.
     * @return map com os jogadores de uma equipa.
     */
    public Map<Integer, Jogador> getJogadores() {
        Map<Integer,Jogador> resultado = new HashMap<>();
        for(Map.Entry<Integer,Jogador> e : jogadores.entrySet()){
            resultado.put(e.getKey(),e.getValue());
            //todo ver clone!
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
            this.jogadores.put(e.getKey(),e.getValue());
            //todo ver clone!
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
                this.numero == resultado.getNumero();
    }

    @Override
    /**
     * Metodo toString para a classe equipa.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).
                append(";Jogadores: ").append(this.nome).append(this.jogadores.values());
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
    public void adicionaJogador(Jogador j) {

        this.jogadores.put(j.getNumero(), j.clone());

    }
}
