import java.util.List;

/**
 * Classe que modela um avancado.
 * @author grupo21
 * @version 1.0
 */
public class Avancado extends Jogador{

    /**
     * Construtor vazio para a classe Avancado.
     */
    public Avancado(){
        super();
    }

    /**
     * Construtor parametrizado para a classe Avancado.
     * @param nome nome do avancado.
     * @param velocidade velocidade do avancado.
     * @param resistencia resistencia do avancado.
     * @param destreza destreza do avancado.
     * @param impulsao impulsao do avancado.
     * @param jogoCabeca jogo de cabeca do avancado.
     * @param remate remate do avancado.
     * @param passe passe do avancado.
     * @param titular true se avancado e titular.
     * @param historial lista com as equipas onde o avancado jogou.
     */
    public Avancado(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                    int remate, int passe, boolean titular, List<String> historial){

        super(nome, velocidade, resistencia, destreza, impulsao, jogoCabeca,
        remate, passe, titular, historial);
    }

    /**
     * Construtor copia para a classe Avancado.
     * @param newAvancado instancia de um avancado.
     */
    public Avancado(Avancado newAvancado){

        super(newAvancado.getNome(), newAvancado.getVelocidade(), newAvancado.getResistencia(), newAvancado.getDestreza(),
                newAvancado.getImpulsao(), newAvancado.getJogoCabeca(), newAvancado.getRemate(),
                newAvancado.getPasse(), newAvancado.isTitular(), newAvancado.getHistorial());

        this.setNumero(newAvancado.getNumero());
    }

    @Override
    /**
     * Metodo equals para a classe Avancado.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Avancado resultado = (Avancado)o;
        return super.equals(resultado);
    }

    @Override
    /**
     * Metodo que permite clonar um Avancado.
     */
    public Avancado clone(){
        return new Avancado(this);
    }

    @Override
    /**
     * Metodo toString para a classe Avancado.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append ("Avancado: ").append(super.toString());

        return sb.toString();
    }

    @Override
    /**
     * Metodo que determina a habilidade de um Avancado.
     * A habilidade e calculada através dos seus atributos.
     * @return int com o valor da habilidade de um avancado.
     */
    public int habilidade(){
        // A DEFINIR NA REUNIAO.
        int resultado = 0;
        return resultado;
    }

}
