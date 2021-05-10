package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um guarda-redes.
 * @author grupo21
 * @version 1.0
 */
public class GuardaRedes extends Jogador {
    //variaveis de instancia
    private int elasticidade;

    /**
     * Construtor vazio para a classe Model.GuardaRedes.
     */
    public GuardaRedes() {
        super();
        this.elasticidade = 0;
    }

    /**
     * Construtor parametrizado para a classe Model.GuardaRedes.
     * @param nome nome do guardaredes.
     * @param velocidade velocidade do guardaredes.
     * @param resistencia resistencia do guardaredes.
     * @param destreza destreza do guardaredes.
     * @param impulsao impulsao do guardaredes.
     * @param jogoCabeca jogo de cabeca do guardaredes.
     * @param remate remate do guardaredes.
     * @param passe passe do guardaredes.
     * @param estado do guardaredes.
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

    /**
     * Construtor copia para a classe guardaredes.
     * @param newgr instancia de um guardaredes.
     */
    public GuardaRedes (GuardaRedes newgr) {
        super (newgr);
        this.elasticidade = newgr.getElasticidade();
    }

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

    @Override
    /**
     * Metodo equals para a classe Model.GuardaRedes.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        GuardaRedes resultado = (GuardaRedes)o;
        return super.equals(resultado) && this.elasticidade == resultado.getElasticidade();
    }

    @Override
    /**
     * Metodo que permite clonar um Model.GuardaRedes.
     */
    public GuardaRedes clone () {
        return new GuardaRedes(this);
    }

    @Override
    /**
     * Metodo toString para a classe GuardaRedes.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append ("Guarda-Redes:")
                .append(super.toString())
                .append(this.elasticidade);
        return sb.toString();
    }

    //Metodos Abstract

    /**
     * Metodo que determina a habilidade de um guardaredes consoante os seus atributos.
     * @return int com a habilidade de um guardaredes.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }

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
