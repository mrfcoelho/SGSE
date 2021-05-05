import java.util.List;

/**
 * Classe que modela um medio.
 * @author grupo21.
 * @version 1.0
 */
public class Medio extends Jogador{

    /**
     * Construtor vazio para a classe Medio.
     */
    public Medio() {
        super();
    }

    /**
     * Construtor parametrizado para a  classe Lateral.
     * @param nome nome de um medio.
     * @param velocidade velocidade de um medio.
     * @param resistencia resistencia de um medio.
     * @param destreza destreza de um medio.
     * @param impulsao impulsao de um medio.
     * @param jogoCabeca jogo de cabeca de um medio.
     * @param remate remate de um medio.
     * @param passe passe de um medio.
     * @param titular titular de um medio.
     * @param historial historial de um medio.
     */
    public Medio (String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                    int remate, int passe, boolean titular, List<String> historial) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, titular, historial);
    }

    /**
     * Construtor copia para a classe Medio.
     * @param newMedio instancia da classe Medio.
     */
    public Medio (Medio newMedio) {
        super (newMedio.getNome(), newMedio.getVelocidade(), newMedio.getResistencia(),
                newMedio.getDestreza(), newMedio.getImpulsao(), newMedio.getJogoCabeca(), newMedio.getRemate(),
                newMedio.getPasse(), newMedio.isTitular(), newMedio.getHistorial());

        this.setNumero(newMedio.getNumero());
    }
    @Override
    /**
     * Metodo equals para a classe Medio.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Medio resultado = (Medio)o;
        return super.equals(resultado);
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
     * Metodo toString para a classe Defesa.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Medio: ").append(super.toString());

        return sb.toString();
    }

    /**
     * Metodo que determina a habilidade de um medio.
     * @return int com a habilidade de um medio.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }
}
