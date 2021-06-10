package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe Guarda-Redes.
 * E subclasse da classe abstracta Jogador.
 * @author grupo21
 * @version 1.0
 */

public class GuardaRedes extends Jogador implements Serializable {
    //variaveis de instancia
    private int elasticidade;

    //variaveis de classe

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe GuardaRedes.
         */
        public GuardaRedes() {
            super();
            this.elasticidade = 0;
        }

        //parametrico
        /**
         * Construtor parametrizado para a classe GuardaRedes.
         * @param nome nome do guardaredes.
         * @param numeroCamisola numero da camisola do guardaredes.
         * @param velocidade velocidade do guardaredes.
         * @param resistencia resistencia do guardaredes.
         * @param destreza destreza do guardaredes.
         * @param impulsao impulsao do guardaredes.
         * @param jogoCabeca jogo de cabeca do guardaredes.
         * @param remate remate do guardaredes.
         * @param passe passe do guardaredes.
         * @param estado do guardaredes. (titular, suplente, entra, sai)
         * @param elasticidade elasticidade do guardaredes.
         * @param historial historial do guardaredes.
         */
        public GuardaRedes (String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                            int impulsao, int jogoCabeca, int remate, int passe, Estado estado,
                            int elasticidade, List<String> historial) {
            super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                    remate, passe, estado, historial);
            this.elasticidade = elasticidade;
        }

        //copia
        /**
         * Construtor copia para a classe guardaredes.
         * @param newgr instancia de um guardaredes.
         */
        public GuardaRedes (GuardaRedes newgr) {
            super (newgr);
            this.elasticidade = newgr.getElasticidade();
        }

    //getters e setters
    /**
     * Metodo getter para a variavel de instancia elasticidade de um guardaredes.
     * @return int com a elasticidade de um guardaredes.
     */
    public int getElasticidade() {
        return elasticidade;
    }

    /**
     * Metodo setter para a varivel elasticidade de um guardaredes.
     * @param elasticidade elasticidade de um guardaredes.
     */
    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        GuardaRedes resultado = (GuardaRedes)o;
        return super.equals(resultado) && this.elasticidade == resultado.getElasticidade();
    }

    @Override
    public GuardaRedes clone () {
        return new GuardaRedes(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append ("Guarda-Redes:")
                .append(super.toString())
                .append(",")
                .append(this.elasticidade);
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
            s = it.next();
            if(s.contains("Habilidade: ")){
                flag = false;
                indexToWrite--;
            }
        }

        res.add(indexToWrite,"Elasticidade: " + this.elasticidade);

        return res;
    }

    //metodos abstract

    //metodos especificos
    /**
     * Metodo que determina a habilidade de um guardaredes consoante os seus atributos.
     * @return int com a habilidade de um guardaredes.
     */
    public int habilidade(){
        return (int)(0.1*this.getVelocidade() + 0.1*this.getResistencia() + 0.2*this.getDestreza() +
                0.2*this.getImpulsao() + 0.1*this.getPasse() + 0.3*this.getElasticidade());
    }

    //metodos de classe
    /**
     * Metodo que faz o parse de um Guarda-Redes.
     * @param input String com um Guarda-Redes em modo de texto.
     * @return um guarda-redes.
     */
    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0],
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
