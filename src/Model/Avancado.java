package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Avancado.
 * É subclasse da classe abstracta Jogador.
 * @author grupo21
 * @version 1.0
 */

public class Avancado extends Jogador{
    //variaveis de instancia

    //variaveis de classe

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe Avancado.
         */
        public Avancado(){
            super();
        }

        //parametrico
        /**
         * Construtor parametrizado para a classe Avancado.
         * @param nome nome do avancado.
         * @param numeroCamisola numero da camisola do avancado.
         * @param velocidade velocidade do avancado.
         * @param resistencia resistencia do avancado.
         * @param destreza destreza do avancado.
         * @param impulsao impulsao do avancado.
         * @param jogoCabeca jogo de cabeca do avancado.
         * @param remate remate do avancado.
         * @param passe passe do avancado.
         * @param estado estado de um avancado. (titular, suplente, entra ou sai)
         * @param historial lista como nome das equipas onde o avancado jogou.
         */
        public Avancado(String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                        int impulsao, int jogoCabeca, int remate, int passe, Estado estado,
                        List<String> historial){
            super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                    remate, passe, estado, historial);
        }

        //copia
        /**
         * Construtor copia para a classe Avancado.
         * @param newAvancado um avancado.
         */
        public Avancado(Avancado newAvancado){
            super(newAvancado);
        }

    //getters e setters

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Avancado resultado = (Avancado)o;
        return super.equals(resultado);
    }

    @Override
    public Avancado clone(){
        return new Avancado(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Avancado:")
                .append(super.toString());
        return sb.toString();
    }

    //metodos abstract

    //metodos especificos
    /**
     * Metodo que determina a habilidade de um avancado.
     * A habilidade e calculada através dos seus atributos.
     * @return int com o valor da habilidade de um avancado.
     */
    public int habilidade(){
        return (int)(0.05*this.getVelocidade() + 0.05*this.getResistencia() + 0.05*this.getDestreza() +
                0.2*this.getImpulsao() + 0.2*this.getJogoCabeca() + 0.4*this.getRemate() +
                0.05*this.getPasse());
    }

    //metodos de classe
    /**
     * Metodo que faz o parse de um avancado.
     * @param input String com um avancado em modo de texto.
     * @return um avancado.
     */
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0],
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Estado.SUPLENTE,
                new ArrayList<>());
    }
}
