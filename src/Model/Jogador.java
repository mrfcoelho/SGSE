package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um jogador.
 * @author grupo21
 * @version 1.0
 */
public abstract class Jogador {
    //variaveis de instancia
    private int id;
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

    public static enum Estado{
        SUPLENTE, TITULAR, SAINDO, ENTRANDO
    }

    /**
     * Metodo getter para a variavel numJogadores.
     * @return int com o total de jogadores que ja foram criados.
     */
    public static int getNumJogadores() {
        return numJogadores;
    }

    /**
     * Metodo getter para a variavel id para a classe Model.Jogador.
     * @return id numero do jogador.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo getter para a variavel de instancia nome da classe Model.Jogador.
     * @return String com o nome de um jogador.
     */
    public String getNome() {
        return nome;
    }

    public int getNumeroCamisola() {
        return numeroCamisola;
    }

    /**
     * Metodo getter para a variavel de instancia velocidade da classe Model.Jogador.
     * @return int com a velocidade de um jogador.
     */
    public int getVelocidade() {

        return velocidade;
    }

    /**
     * Metodo getter para a variavel de instancia resistencia da classe Model.Jogador.
     * @return int com a resistencia de um jogador.
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Metodo getter para a variavel de instancia destreza da classe Model.Jogador.
     * @return int com a destreza de um jogador.
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Metodo getter para a variavel de instancia impulsao da classe Model.Jogador.
     * @return int com a impulsao de um jogador.
     */
    public int getImpulsao() {
        return impulsao;
    }

    /**
     * Metodo getter para a variavel de instancia jogoCabeca da classe Model.Jogador.
     * @return int com o jogoCabeca de um jogador.
     */
    public int getJogoCabeca() {
        return jogoCabeca;
    }

    /**
     * Metodo getter para a variavel de instancia remate para a classe Model.Jogador.
     * @return int com o remate de um jogador.
     */
    public int getRemate() {
        return remate;
    }

    /**
     * Metodo getter para a variavel passe da classe Model.Jogador.
     * @return int com o valor de passe de um jogador.
     */
    public int getPasse() {
        return passe;
    }

    /**
     * Metodo getter para a variavel de instancia titular da classe Model.Jogador.
     * @return booleano com o valor de titular de um jogador.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Metodo getter para a variavel de instancia historial para a classe Model.Jogador.
     * @return Lista com as equipas em que o jogador jogou.
     */
    public List<String> getHistorial() {

        return new ArrayList<>(this.historial);
    }

    /**
     * Metodo setter para a variavel de instancia nome da classe Model.Jogador.
     * @param nome String com o nome de um jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroCamisola(int numeroCamisola) {
        this.numeroCamisola = numeroCamisola;
    }

    /**
     * Metodo setter para a variavel de instancia velocidade para a classe Model.Jogador.
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
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo setter para a variavel de instancia impulsao da classe Model.Jogador.
     * @param impulsao impulsao de um jogador.
     */
    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    /**
     * Metodo setter para a variavel de instancia jogoCabeca da classe Model.Jogador.
     * @param jogoCabeca jogoCabeca de um jogador.
     */
    public void setJogoCabeca(int jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }

    /**
     * Metodo setter para a variavel de instancia remate da classe Model.Jogador.
     * @param remate remate de um jogador.
     */
    public void setRemate(int remate) {
        this.remate = remate;
    }

    /**
     * Metodo setter para a variavel de instancia passe da classe Model.Jogador.
     * @param passe passe de um jogador.
     */
    public void setPasse(int passe) {
        this.passe = passe;
    }

    /**
     * Metodo setter para a variavel de instancia titular da classe Model.Jogador.
     * @param novoEstado titular de um jogador.
     */
    public void setEstado(Estado novoEstado) {
        this.estado = novoEstado;
    }

    /**
     * Metodo setter para a variavel de instancia historial da classe Model.Jogador.
     * @param historial lista com as equipas onde o jogador jogou.
     */
    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>(historial);
    }

    /**
     * Construtor vazio para a classe Model.Jogador.
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

    /**
     * Construtor parametrizado para a classe Model.Jogador.
     * @param nome nome de um jogador.
     * @param velocidade velocidade de um jogador.
     * @param resistencia resistencia de um jogador.
     * @param destreza destreza de um jogador.
     * @param impulsao impulsao de um jogador.
     * @param jogoCabeca jogo de cabeca de um jogador.
     * @param remate remate de um jogador.
     * @param passe passe de um jogador.
     * @param estado de um jogador.
     * @param historial historial de um jogador.
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

    /**
     * Construtor copia para a classe Model.Jogador.
     * @param jogador instancia da classe Model.Jogador.
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

    //metodos override

    @Override
    /**
     * Metodo equals para a classe Model.Jogador.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Jogador resultado = (Jogador) o;
        return this.id == resultado.getId() &&
                this.nome.equals(resultado.getNome()) &&
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
                .append(this.passe).append(",");
        return sb.toString();
    }

    /**
     * Metodo abstracto que determina a habilidade de um jogador consoante os seus atributos.
     * @return double com a habilidade de um jogador.
     */
    public abstract int habilidade();

    public abstract Jogador clone();

    public static Jogador parse(String input) {
        return null;
    }
}