package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que modela um lateral.
 * E subclasse da classe Jogador.
 * @author grupo21
 * @version 1.0
 */

public class Lateral extends Jogador{
    //variaveis de instancia
    private int cruzamento;

    //variaveis de classe

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe Lateral.
         */
        public Lateral() {
            super();
            this.cruzamento = 0;
        }

        //parametrico
        /**
         * Construtor parametrizado para a  classe Lateral.
         * @param nome nome de um lateral.
         * @param numeroCamisola numero da camisola de um lateral.
         * @param velocidade velocidade de um lateral.
         * @param resistencia resistencia de um lateral.
         * @param destreza destreza de um lateral.
         * @param impulsao impulsao de um lateral.
         * @param jogoCabeca jogo de cabeca de um lateral.
         * @param remate remate de um lateral.
         * @param passe passe de um lateral.
         * @param estado de um lateral. (titular, suplente, entra, sai)
         * @param historial historial de um lateral.
         */
        public Lateral (String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                        int impulsao, int jogoCabeca, int remate, int passe, Estado estado, int cruzamento,
                        List<String> historial) {
            super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                    remate, passe, estado, historial);
            this.cruzamento = cruzamento;
        }

        //copia
        /**
         * Construtor copia para a classe Defesa.
         * @param newLateral instancia da classe Model.Defesa.
         */
        public Lateral (Lateral newLateral) {
            super (newLateral);
            this.setCruzamento(newLateral.getCruzamento());
        }

    //getters e setters
    public int getCruzamento(){
        return this.cruzamento;
    }

    public void setCruzamento(int cruzamento){
        this.cruzamento = cruzamento;
    }

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Lateral resultado = (Lateral)o;
        return super.equals(resultado);
    }

    @Override
    public Lateral clone () {
        return new Lateral(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Lateral:")
                .append(super.toString())
                .append(",")
                .append(this.cruzamento);
        return sb.toString();
    }

    @Override
    public List<String> consultaJogador(){
        List<String> res = super.consultaJogador();
        Iterator<String> it = res.iterator();
        boolean flag = true;
        String s;

        int indexToWrite=-1;

        while(it.hasNext() && flag) {
            indexToWrite++;
            s = (String)it.next();
            if(s.contains("Habilidade: ")){
                flag = false;
                indexToWrite--;
            }
        }

        res.add(indexToWrite,"Cruzamento: " + this.cruzamento);

        return res;
    }

    //metodos abstract

    //metodos especificos
    /**
     * Metodo que determina a habilidade de um lateral consoante os seus atributos.
     * @return int com o valor da habilidade um lateral.
     */
    public int habilidade(){
        return (int)(0.1*this.getVelocidade() + 0.1*this.getResistencia() + 0.15*this.getDestreza() +
                0.1*this.getImpulsao() + 0.1*this.getJogoCabeca() + 0.1*this.getRemate() +
                0.1*this.getPasse() + 0.25*this.getCruzamento());
    }

    //metodos de classe
    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0],
                Integer.parseInt(campos[1]),
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
