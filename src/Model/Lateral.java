package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela um lateral.
 * @author grupo21
 * @version 1.0
 */
public class Lateral extends Jogador{
    private int cruzamento;

    /**
     * Construtor vazio para a classe Model.Lateral.
     */
    public Lateral() {
        super();
        this.cruzamento = 0;
    }

    /**
     * Construtor parametrizado para a  classe Model.Lateral.
     * @param nome nome de um lateral.
     * @param velocidade velocidade de um lateral.
     * @param resistencia resistencia de um lateral.
     * @param destreza destreza de um lateral.
     * @param impulsao impulsao de um lateral.
     * @param jogoCabeca jogo de cabeca de um lateral.
     * @param remate remate de um lateral.
     * @param passe passe de um lateral.
     * @param estado de um lateral.
     * @param historial historial de um lateral.
     */
    public Lateral (String nome, int numeroCamisola, int velocidade, int resistencia, int destreza,
                    int impulsao, int jogoCabeca, int remate, int passe, Estado estado, int cruzamento,
                    List<String> historial) {
        super(nome, numeroCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, estado, historial);
        this.cruzamento = cruzamento;
    }

    /**
     * Construtor copia para a classe Model.Defesa.
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
    /**
     * Metodo equals para a classe Model.Lateral.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Lateral resultado = (Lateral)o;
        return super.equals(resultado);
    }

    @Override
    /**
     * Metodo que permite clonar um lateral.
     */
    public Lateral clone () {
        return new Lateral(this);
    }

    @Override
    /**
     * Metodo toString para a classe Model.Defesa.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Lateral:")
                .append(super.toString())
                .append(this.cruzamento);
        return sb.toString();
    }

    //metodos abstract

    /**
     * Metodo que determina a habilidade de um lateral consoante os seus atributos.
     * @return int com o valor da habilidade um lateral.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Estado.valueOf(campos[9]),
                Integer.parseInt(campos[10]),
                new ArrayList<>());
    }
}
