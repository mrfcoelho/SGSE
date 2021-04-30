import java.util.Map;
import java.util.TreeMap;

public abstract class Jogador {
    //variaveis de instancia
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int passe;
    private boolean titular;
    private Map<String,String> historial;

    //variaveis de classe

    //getters e setters

    public int getVelocidade() {
        return velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public int getJogoCabeca() {
        return jogoCabeca;
    }

    public int getRemate() {
        return remate;
    }

    public int getPasse() {
        return passe;
    }

    public boolean isTitular() {
        return titular;
    }

    public Map<String, String> getHistorial() {
        return historial;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public void setJogoCabeca(int jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public void setHistorial(Map<String, String> historial) {
        this.historial = historial;
    }

    //construtor
    public Jogador(){
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoCabeca = 0;
        this.remate = 0;
        this.passe = 0;
        this.titular = false;
        this.historial = new TreeMap<>();
    }

    public Jogador(int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                   int remate, int passe, boolean titular, Map<String, String> historial) {
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoCabeca = jogoCabeca;
        this.remate = remate;
        this.passe = passe;
        this.titular = titular;
        this.historial = historial;
    }

    public Jogador(Jogador jogador){
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

    //metodos override

    //metodos especificos
    public abstract double habilidade();

    public void transfere(Equipa destino){
        return;
    }
}
