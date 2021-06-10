package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um jogador.
 * @author grupo21
 * @version 1.0
 */

public abstract class Jogador implements Serializable {
    //variaveis de instancia
    private final int id;
    private String nome;
    private int numeroCamisola;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int passe;
    private Estado estado;
    private List<String> historial;

    //variaveis de class
    private static int numJogadores; // numero de jogadores qe ja foram criados.

    public enum Estado{
        SUPLENTE, TITULAR, SAINDO, ENTRANDO
    }

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe Jogador.
         */
        public Jogador() {
            numJogadores++;
            this.id = numJogadores;
            this.nome = "";
            this.numeroCamisola = 0;
            this.velocidade = 0;
            this.resistencia = 0;
            this.destreza = 0;
            this.impulsao = 0;
            this.jogoCabeca = 0;
            this.remate = 0;
            this.passe = 0;
            this.estado = Estado.SUPLENTE;
            this.historial = new ArrayList<>();
        }
        //parametrico
        /**
         * Construtor parametrizado para a classe Jogador.
         * @param nome nome de um jogador.
         * @param numeroCamisola numero da camisola de um jogador.
         * @param velocidade velocidade de um jogador.
         * @param resistencia resistencia de um jogador.
         * @param destreza destreza de um jogador.
         * @param impulsao impulsao de um jogador.
         * @param jogoCabeca jogo de cabeca de um jogador.
         * @param remate remate de um jogador.
         * @param passe passe de um jogador.
         * @param estado de um jogador.
         * @param historial nome das equipas onde o jogador jogou.
         */
        public Jogador(String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                       int impulsao, int jogoCabeca, int remate, int passe, Estado estado,
                       List<String> historial) {
            numJogadores++;
            this.id = numJogadores;
            this.nome = nome;
            this.numeroCamisola = numeroCamisola;
            this.velocidade = velocidade;
            this.resistencia = resistencia;
            this.destreza = destreza;
            this.impulsao = impulsao;
            this.jogoCabeca = jogoCabeca;
            this.remate = remate;
            this.passe = passe;
            this.estado = estado;
            this.historial = new ArrayList<>(historial);
        }

        //copia
        /**
         * Construtor copia para a classe Jogador.
         * @param jogador instancia da classe Jogador.
         */
        public Jogador(Jogador jogador) {
            this.id = jogador.getId();
            this.nome = jogador.getNome();
            this.numeroCamisola = jogador.getNumeroCamisola();
            this.velocidade = jogador.getVelocidade();
            this.resistencia = jogador.getResistencia();
            this.destreza = jogador.getDestreza();
            this.impulsao = jogador.getImpulsao();
            this.jogoCabeca = jogador.getJogoCabeca();
            this.remate = jogador.getRemate();
            this.passe = jogador.getPasse();
            this.estado = jogador.getEstado();
            this.historial = jogador.getHistorial();
        }

    //getters e setters
    /**
     * Metodo getter para a variavel numJogadores.
     * @return int com o total de jogadores que ja foram criados.
     */
    public static int getNumJogadores() {
        return numJogadores;
    }

    /**
     * Metodo getter para a variavel id para a classe Jogador.
     * @return id numero do jogador.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo getter para a variavel de instancia nome da classe Jogador.
     * @return String com o nome de um jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo getter para a variavel de instancia numeroCamisola da classe Jogador.
     * @return int com o numeroCamisola de um jogador.
     */
    public int getNumeroCamisola() {
        return numeroCamisola;
    }

    /**
     * Metodo getter para a variavel de instancia velocidade da classe Jogador.
     * @return int com a velocidade de um jogador.
     */
    public int getVelocidade() { return velocidade; }

    /**
     * Metodo getter para a variavel de instancia resistencia da classe Jogador.
     * @return int com a resistencia de um jogador.
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Metodo getter para a variavel de instancia destreza da classe Jogador.
     * @return int com a destreza de um jogador.
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Metodo getter para a variavel de instancia impulsao da classe Jogador.
     * @return int com a impulsao de um jogador.
     */
    public int getImpulsao() {
        return impulsao;
    }

    /**
     * Metodo getter para a variavel de instancia jogoCabeca da classe Jogador.
     * @return int com o jogoCabeca de um jogador.
     */
    public int getJogoCabeca() {
        return jogoCabeca;
    }

    /**
     * Metodo getter para a variavel de instancia remate para a classe Jogador.
     * @return int com o remate de um jogador.
     */
    public int getRemate() {
        return remate;
    }

    /**
     * Metodo getter para a variavel passe da classe Jogador.
     * @return int com o valor de passe de um jogador.
     */
    public int getPasse() {
        return passe;
    }

    /**
     * Metodo getter para a variavel de instancia titular da classe Jogador.
     * @return Estado de um jogador.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Metodo getter para a variavel de instancia historial para a classe Jogador.
     * @return Lista com as equipas em que o jogador jogou.
     */
    public List<String> getHistorial() { return new ArrayList<>(this.historial); }

    /**
     * Metodo setter para a variavel de instancia nome da classe Jogador.
     * @param nome String com o nome de um jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroCamisola(int numeroCamisola) {
        this.numeroCamisola = numeroCamisola;
    }

    /**
     * Metodo setter para a variavel de instancia velocidade para a classe Jogador.
     * @param velocidade velocidade de um jogador.
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Metodo setter para variavel de instancia resistencia para a classe Model.Jogador.
     * @param resistencia resistencia de um jogador.
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Metodo setter para a variavel de instancia destreza para a classe Joagdor.
     * @param destreza destreza de um jogador.
     */
    public void setDestreza(int destreza) { this.destreza = destreza; }

    /**
     * Metodo setter para a variavel de instancia impulsao da classe Jogador.
     * @param impulsao impulsao de um jogador.
     */
    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    /**
     * Metodo setter para a variavel de instancia jogoCabeca da classe Jogador.
     * @param jogoCabeca jogoCabeca de um jogador.
     */
    public void setJogoCabeca(int jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }

    /**
     * Metodo setter para a variavel de instancia remate da classe Jogador.
     * @param remate remate de um jogador.
     */
    public void setRemate(int remate) {
        this.remate = remate;
    }

    /**
     * Metodo setter para a variavel de instancia passe da classe Jogador.
     * @param passe passe de um jogador.
     */
    public void setPasse(int passe) {
        this.passe = passe;
    }

    /**
     * Metodo setter para a variavel de instancia titular da classe Jogador.
     * @param novoEstado titular de um jogador.
     */
    public void setEstado(Estado novoEstado) {
        this.estado = novoEstado;
    }

    /**
     * Metodo setter para a variavel de instancia historial da classe Jogador.
     * @param historial lista com as equipas onde o jogador jogou.
     */
    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>(historial);
    }

    //metodos override
    @Override
    /**
     * Metodo equals para a classe Jogador.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Jogador resultado = (Jogador) o;
        return  this.nome.equals(resultado.getNome()) &&
                this.numeroCamisola == resultado.getNumeroCamisola() &&
                this.velocidade == resultado.getVelocidade() &&
                this.resistencia == resultado.getResistencia() &&
                this.destreza == resultado.getDestreza() &&
                this.impulsao == resultado.getImpulsao() &&
                this.jogoCabeca == resultado.getJogoCabeca() &&
                this.remate == resultado.getRemate() &&
                this.passe == resultado.getPasse() &&
                this.estado.equals(resultado.getEstado());
    }

    @Override
    /**
     * Metodo toString para a classe jogador.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.nome).append(",")
                .append(this.numeroCamisola).append(",")
                .append(this.velocidade).append(",")
                .append(this.resistencia).append(",")
                .append(this.destreza).append(",")
                .append(this.impulsao).append(",")
                .append(this.jogoCabeca).append(",")
                .append(this.remate).append(",")
                .append(this.passe);
        return sb.toString();
    }

    //metodos abstract
    /**
     * Metodo abstracto que determina a habilidade de um jogador consoante os seus atributos.
     * @return double com a habilidade de um jogador.
     */
    public abstract int habilidade();

    public abstract Jogador clone();

    //metodos especificos
    public void atualizaHistorial(String nome){ this.historial.add(nome); }

    public List<String> consultaJogador(){
        List <String> result = new ArrayList<> ();

        result.add("Posição: " + this.getClass().getSimpleName());
        result.add("");
        result.add("Nome: " + this.nome);
        result.add("Numero de camisola: " + this.numeroCamisola);
        result.add("Velocidade: " + this.velocidade);
        result.add("Destreza: " + this.destreza);
        result.add("Impulsão: " + this.impulsao);
        result.add("Jogo de cabeça: " + this.jogoCabeca);
        result.add("Remate: " + this.remate);
        result.add("Passe: " + this.passe);
        result.add("");
        result.add("Habilidade: " + this.habilidade());
        result.add("");
        result.add("Historial:");
        result.addAll(this.historial);

        return result;
    }

    //metodos de classe
    public static Jogador parse(String input) {
        return null;
    }
}
