import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um jogador.
 * @author grupo21
 * @version 1.0
 */
public abstract class Jogador {

    private static int numJogadores; // numero de jogadores qe ja foram criados.

    private String nome;
    private int numero;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int passe;
    private boolean titular;
    private List<String> historial;

    /**
     * Metodo getter para a variavel de instancia nome da classe Jogador.
     * @return String com o nome de um jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo getter para a variavel numJogadores.
     * @return int com o numero de jogadores que ja foram criados.
     */
    public static int getNumJogadores() {
        return numJogadores;
    }

    /**
     * Metodo setter para a variavel de instancia numJogadores.
     * @param numJogadores int com o numero de jogadores que ja foram criados.
     */
    public static void setNumJogadores(int numJogadores) {
        Jogador.numJogadores = numJogadores;
    }

    /**
     * Metodo getter para a variavel numero para a classe Jogador.
     * @return numero numero do jogador.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo setter para a variavel numero para a classe Jogador.
     * @param numero numero do jogador.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo setter para a variavel de instancia nome da classe Jogador.
     * @param nome String com o nome de um jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo getter para a variavel de instancia velocidade da classe Jogador.
     * @return int com a velocidade de um jogador.
     */
    public int getVelocidade() {

        return velocidade;
    }

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
     * @return booleano com o valor de titular de um jogador.
     */
    public boolean isTitular() {
        return titular;
    }

    /**
     * Metodo getter para a variavel de instancia historial para a classe Jogador.
     * @return Lista com as equipas em que o jogador jogou.
     */
    public List<String> getHistorial() {

        return new ArrayList<>(this.historial);
    }

    /**
     * Metodo setter para a variavel de instancia velocidade para a classe Jogador.
     * @param velocidade velocidade de um jogador.
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Metodo setter para variavel de instancia resistencia para a classe Jogador.
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
     * @param titular titular de um jogador.
     */
    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    /**
     * Metodo setter para a variavel de instancia historial da classe Jogador.
     * @param historial lista com as equipas onde o jogador jogou.
     */
    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>(historial);
    }

    /**
     * Construtor vazio para a classe Jogador.
     */
    public Jogador() {

        this.numJogadores++;
        this.numero = this.numJogadores;
        this.nome = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoCabeca = 0;
        this.remate = 0;
        this.passe = 0;
        this.titular = false;
        this.historial = new ArrayList<>();
    }

    /**
     * Construtor parametrizado para a classe Jogador.
     * @param nome nome de um jogador.
     * @param velocidade velocidade de um jogador.
     * @param resistencia resistencia de um jogador.
     * @param destreza destreza de um jogador.
     * @param impulsao impulsao de um jogador.
     * @param jogoCabeca jogo de cabeca de um jogador.
     * @param remate remate de um jogador.
     * @param passe passe de um jogador.
     * @param titular titular de um jogador.
     * @param historial historial de um jogador.
     */
    public Jogador(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                   int remate, int passe, boolean titular, List<String> historial) {

        this.numJogadores++;

        this.numero = this.numJogadores;
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoCabeca = jogoCabeca;
        this.remate = remate;
        this.passe = passe;
        this.titular = titular;
        this.historial = new ArrayList<>(historial);
    }

    /**
     * Construtor copia para a classe Jogador.
     * @param jogador instancia da classe Jogador.
     */
    public Jogador(Jogador jogador) {

        this.numJogadores++;
        this.numero = this.numJogadores;
        this.nome = jogador.getNome();
        this.velocidade = jogador.getVelocidade();
        this.resistencia = jogador.getResistencia();
        this.destreza = jogador.getDestreza();
        this.impulsao = jogador.getImpulsao();
        this.jogoCabeca = jogador.getJogoCabeca();
        this.remate = jogador.getRemate();
        this.passe = jogador.getPasse();
        this.titular = jogador.isTitular();
        this.historial = jogador.getHistorial();
    }

    @Override
    /**
     * Metodo equals para a classe Jogador.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Jogador resultado = (Jogador) o;
        return this.nome.equals(resultado.getNome())&&
                this.numero == resultado.getNumero() &&
                this.velocidade == resultado.getVelocidade() &&
                this.resistencia == resultado.getResistencia() &&
                this.destreza == resultado.getDestreza() &&
                this.impulsao == resultado.getImpulsao() &&
                this.jogoCabeca == resultado.getJogoCabeca() &&
                this.remate == resultado.getRemate() &&
                this.passe == resultado.getPasse() &&
                this.titular == resultado.isTitular();
    }

    @Override
    /**
     * Metodo toString para a classe jogador.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome)
                .append("; Numero: ").append(this.numero)
        .append("; Velocidade: ").append(this.velocidade)
                .append("; Resistencia: ").append(this.resistencia)
                .append("; Destreza: ").append(this.destreza)
                .append("; Impulsao: ").append(this.impulsao)
                .append("; JogoCabeca: ").append(this.jogoCabeca)
                .append("; Remate: ").append(this.remate)
                .append("; Passe: ").append(this.passe)
                .append("; Titular: ").append(this.titular)
                .append("; Historial: ").append(this.historial);
        return sb.toString();
    }

    /**
     * Metodo abstracto que determina a habilidade de um jogador consoante os seus atributos.
     * @return double com a habilidade de um jogador.
     */
    public abstract int habilidade();
}
