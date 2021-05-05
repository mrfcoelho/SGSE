import java.util.List;

/**
 * Classe que modela um guarda-redes.
 * @author grupo21
 * @version 1.0
 */
public class GuardaRedes extends Jogador {

    private int elasticidade;

    /**
     * Construtor vazio para a classe GuardaRedes.
     */
    public GuardaRedes() {
        super();
    }

    /**
     * Construtor parametrizado para a classe GuardaRedes.
     * @param nome nome do guardaredes.
     * @param velocidade velocidade do guardaredes.
     * @param resistencia resistencia do guardaredes.
     * @param destreza destreza do guardaredes.
     * @param impulsao impulsao do guardaredes.
     * @param jogoCabeca jogo de cabeca do guardaredes.
     * @param remate remate do guardaredes.
     * @param passe passe do guardaredes.
     * @param titular titular do guardaredes.
     * @param historial historial do guardaredes.
     */
    public GuardaRedes (String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                    int remate, int passe, boolean titular, int elasticidade, List<String> historial) {
        super(nome, velocidade, resistencia, destreza, impulsao, jogoCabeca,
                remate, passe, titular, historial);
        this.elasticidade = elasticidade;
    }

    /**
     * Construtor copia para a classe guardaredes.
     * @param newgr instancia de um guardaredes.
     */
    public GuardaRedes (GuardaRedes newgr) {
        super (newgr.getNome(), newgr.getVelocidade(), newgr.getResistencia(),
                newgr.getDestreza(), newgr.getImpulsao(), newgr.getJogoCabeca(), newgr.getRemate(),
                newgr.getPasse(), newgr.isTitular(), newgr.getHistorial());
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

    /**
     * Metodo que determina a habilidade de um guardaredes consoante os seus atributos.
     * @return int com a habilidade de um guardaredes.
     */
    public int habilidade(){
        int resultado = 0;
        return resultado;
    }
    @Override
    /**
     * Metodo equals para a classe GuardaRedes.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        GuardaRedes resultado = (GuardaRedes)o;
        return super.equals(resultado) && this.elasticidade == resultado.getElasticidade();
    }

    @Override
    /**
     * Metodo que permite clonar um GuardaRedes.
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
        sb.append ("GuardaRedes: ").append(super.toString()).append("; Elastcidade: ").append(this.elasticidade);

        return sb.toString();
    }
}
