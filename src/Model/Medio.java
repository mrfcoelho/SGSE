package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um medio.
 * @author grupo21.
 * @version 1.0
 */
public class Medio extends Jogador{
    private int recuperacao;

    /**
     * Construtor vazio para a classe Medio.
     */
    public Medio() {
        super();
        this.recuperacao = 0;
    }

    /**
     * Construtor parametrizado para a  classe Model.Lateral.
     * @param nome nome de um medio.
     * @param velocidade velocidade de um medio.
     * @param resistencia resistencia de um medio.
     * @param destreza destreza de um medio.
     * @param impulsao impulsao de um medio.
     * @param jogoCabeca jogo de cabeca de um medio.
     * @param remate remate de um medio.
     * @param passe passe de um medio.
     * @param estado de um medio.
     * @param historial historial de um medio.
     */
    public Medio (String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                  int impulsao, int jogoCabeca, int remate, int passe, Estado estado, int recuperacao,
                  List<String> historial) {
        super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, estado, historial);
        this.recuperacao = recuperacao;
    }

    /**
     * Construtor copia para a classe Model.Medio.
     * @param newMedio instancia da classe Model.Medio.
     */
    public Medio (Medio newMedio) {
        super (newMedio);
        this.recuperacao = newMedio.getRecuperacao();
    }

    //getters e setters
    public int getRecuperacao(){
        return this.recuperacao;
    }

    public void setRecuperacao(int recuperacao){
        this.recuperacao = recuperacao;
    }

    //metodos override

    @Override
    /**
     * Metodo equals para a classe Model.Medio.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Medio resultado = (Medio)o;
        return super.equals(resultado) &&
                this.recuperacao == resultado.getRecuperacao();
    }

    @Override
    /**
     * Metodo que permite clonar um medio.
     */
    public Medio clone () {
        return new Medio(this);
    }

    @Override
    /**
     * Metodo toString para a classe Model.Defesa.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Medio:")
                .append(super.toString())
                .append(this.getRecuperacao());
        return sb.toString();
    }

    //metodos abstract

    /**
     * Metodo que determina a habilidade de um medio.
     * @return int com a habilidade de um medio.
     */
    public int habilidade(){
        return (int)(0.05*this.getVelocidade() + 0.05*this.getResistencia() + 0.05*this.getDestreza() +
                0.1*this.getImpulsao() + 0.1*this.getJogoCabeca() + 0.2*this.getRemate() +
                0.05*this.getPasse() + 0.4*this.getRecuperacao());
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Estado.SUPLENTE,
                Integer.parseInt(campos[9]),
                new ArrayList<>());
    }
}
