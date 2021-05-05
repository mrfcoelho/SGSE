import java.util.List;

/**
 * Classe que modela um defesa.
 * @author grupo21
 * @version 1.0
 */
public class Defesa extends Jogador{

    /**
     * Construtor vazio para a classe Defesa.
     */
    public Defesa() {
        super();
    }

    /**
     * Construtor parametrizado para a classe Defesa.
     * @param nome nome de um defesa.
     * @param velocidade velocidade de um defesa.
     * @param resistencia resistencia de um defesa.
     * @param destreza destreza de um defesa.
     * @param impulsao impulsao de um defesa.
     * @param jogoCabeca jogo de cabeca de um defesa.
     * @param remate remate de um defesa.
     * @param passe passe de um defesa.
     * @param titular titular de um defesa.
     * @param historial historial de um defesa.
     */
    public Defesa (String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                   int remate, int passe, boolean titular, List<String> historial) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, titular, historial);
    }

    /**
     * Construtor copia para a classe Defesa.
     * @param newDefesa instancia da classe Defesa.
     */
    public Defesa (Defesa newDefesa) {
        super (newDefesa.getNome(), newDefesa.getVelocidade(), newDefesa.getResistencia(),
                newDefesa.getDestreza(), newDefesa.getImpulsao(), newDefesa.getJogoCabeca(), newDefesa.getRemate(),
                newDefesa.getPasse(), newDefesa.isTitular(), newDefesa.getHistorial());
    }

    @Override
    /**
     * Metodo que determina a habilidade de um jogador, consoante os seus atributos.
     * @return int com o valor da habilidade de um defesa.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }

    @Override
    /**
     * Metodo equals para a classe Defesa.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Defesa resultado = (Defesa)o;
        return super.equals(resultado);
    }

    @Override
    /**
     * Metodo que permite clonar um defesa.
     */
    public Defesa clone () {
        return new Defesa(this);
    }
    @Override
    /**
     * Metodo toString para a classe Defesa.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Defesa: ").append(super.toString());

        return sb.toString();
    }
}
