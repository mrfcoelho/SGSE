import java.util.List;

/**
 * Classe que modela um lateral.
 * @author grupo21
 * @version 1.0
 */
public class Lateral extends Jogador{

    /**
     * Construtor vazio para a classe Lateral.
     */
    public Lateral() {
        super();
    }

    /**
     * Construtor parametrizado para a  classe Lateral.
     * @param nome nome de um lateral.
     * @param velocidade velocidade de um lateral.
     * @param resistencia resistencia de um lateral.
     * @param destreza destreza de um lateral.
     * @param impulsao impulsao de um lateral.
     * @param jogoCabeca jogo de cabeca de um lateral.
     * @param remate remate de um lateral.
     * @param passe passe de um lateral.
     * @param titular titular de um lateral.
     * @param historial historial de um lateral.
     */
    public Lateral (String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                   int remate, int passe, boolean titular, List<String> historial) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, titular, historial);
    }

    /**
     * Construtor copia para a classe Defesa.
     * @param newLateral instancia da classe Defesa.
     */
    public Lateral (Lateral newLateral) {
        super (newLateral.getNome(), newLateral.getVelocidade(), newLateral.getResistencia(),
                newLateral.getDestreza(), newLateral.getImpulsao(), newLateral.getJogoCabeca(), newLateral.getRemate(),
                newLateral.getPasse(), newLateral.isTitular(), newLateral.getHistorial());
    }

    /**
     * Metodo que determina a habilidade de um lateral consoante os seus atributos.
     * @return int com o valor da habilidade um lateral.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }

    @Override
    /**
     * Metodo equals para a classe Lateral.
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
     * Metodo toString para a classe Defesa.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Lateral: ").append(super.toString());

        return sb.toString();
    }
}
