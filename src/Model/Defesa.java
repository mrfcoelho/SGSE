package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Defesa.
 * E subclasse da classe abstracta Jogador.
 * @author grupo21
 * @version 1.0
 */

public class Defesa extends Jogador{
    //variaveis de instancia

    //variaveis de classe

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe Defesa.
         */
        public Defesa() {
            super();
        }

        //parametrico
        /**
         * Construtor parametrizado para a classe Defesa.
         * @param nome nome de um defesa.
         * @param numeroCamisola numero da camisola de um defesa.
         * @param velocidade velocidade de um defesa.
         * @param resistencia resistencia de um defesa.
         * @param destreza destreza de um defesa.
         * @param impulsao impulsao de um defesa.
         * @param jogoCabeca jogo de cabeca de um defesa.
         * @param remate remate de um defesa.
         * @param passe passe de um defesa.
         * @param estado estado de um defesa. (titular, suplente, entra ou sai)
         * @param historial nome das equipas onde o defesa jogou.
         */
        public Defesa (String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                       int impulsao, int jogoCabeca, int remate, int passe, Estado estado,
                       List<String> historial) {
            super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                    remate, passe, estado, historial);
        }

        //copia
        /**
         * Construtor copia para a classe Defesa.
         * @param newDefesa instancia da classe Defesa.
         */
        public Defesa (Defesa newDefesa) {
            super (newDefesa);
        }

    //getters e setters

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Defesa resultado = (Defesa)o;
        return super.equals(resultado);
    }

    @Override
    public Defesa clone () {
        return new Defesa(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append ("Defesa:")
                .append(super.toString());
        return sb.toString();
    }

    //metodos abstract

    //metodos especificos
    /**
     * Metodo que determina a habilidade de um jogador, consoante os seus atributos.
     * @return int com o valor da habilidade de um defesa.
     */
    public int habilidade(){
        return (int)(0.2*this.getVelocidade() + 0.2*this.getResistencia() + 0.05*this.getDestreza() +
                0.2*this.getImpulsao() + 0.2*this.getJogoCabeca() + 0.05*this.getRemate() +
                0.1*this.getPasse());
    }

    //metodos de classe
    /**
     * Metodo que faz o parse de um defesa.
     * @param input String com um defesa em modo de texto.
     * @return um defesa.
     */
    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0],
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
