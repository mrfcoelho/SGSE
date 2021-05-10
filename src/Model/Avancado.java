package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um avancado.
 * @author grupo21
 * @version 1.0
 */
public class Avancado extends Jogador{

    /**
     * Construtor vazio para a classe Model.Avancado.
     */
    public Avancado(){
        super();
    }

    /**
     * Construtor parametrizado para a classe Model.Avancado.
     * @param nome nome do avancado.
     * @param velocidade velocidade do avancado.
     * @param resistencia resistencia do avancado.
     * @param destreza destreza do avancado.
     * @param impulsao impulsao do avancado.
     * @param jogoCabeca jogo de cabeca do avancado.
     * @param remate remate do avancado.
     * @param passe passe do avancado.
     * @param estado de um avancado.
     * @param historial lista com as equipas onde o avancado jogou.
     */
    public Avancado(String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                    int impulsao, int jogoCabeca, int remate, int passe, Estado estado,
                    List<String> historial){
        super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
        remate, passe, estado, historial);
    }

    /**
     * Construtor copia para a classe Model.Avancado.
     * @param newAvancado instancia de um avancado.
     */
    public Avancado(Avancado newAvancado){
        super(newAvancado);
    }

    //metodos override

    @Override
    /**
     * Metodo equals para a classe Model.Avancado.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Avancado resultado = (Avancado)o;
        return super.equals(resultado);
    }

    @Override
    /**
     * Metodo que permite clonar um Model.Avancado.
     */
    public Avancado clone(){
        return new Avancado(this);
    }

    @Override
    /**
     * Metodo toString para a classe Model.Avancado.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Avancado:")
                .append(super.toString());
        return sb.toString();
    }

    //metodos abstract

    /**
     * Metodo que determina a habilidade de um Model.Avancado.
     * A habilidade e calculada através dos seus atributos.
     * @return int com o valor da habilidade de um avancado.
     */
    public int habilidade(){
        return (int)(0.05*this.getVelocidade() + 0.05*this.getResistencia() + 0.05*this.getDestreza() +
                0.2*this.getImpulsao() + 0.2*this.getJogoCabeca() + 0.4*this.getRemate() +
                0.05*this.getPasse());
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Estado.valueOf(campos[9]),
                new ArrayList<>());
    }

}
