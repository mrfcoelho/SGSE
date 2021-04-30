
public class Jogo {
    //variaveis de instancia
    private Equipa visitado;
    private Equipa visitante;

    //variaveis de classe

    //getters e setters
    public Equipa getVisitado() {
        return this.visitado;
    }

    public Equipa getVisitante() {
        return this.visitante;
    }

    public void setVisitado(Equipa newVisitado) {
        this.visitado = newVisitado;
    }

    public void setVisitante(Equipa newVisitante) {
        this.visitante = newVisitante;
    }

    //construtor
    public Jogo(){
        this.visitado = new Equipa();
        this.visitante = new Equipa();
    }

    public Jogo(Equipa visitado, Equipa visitante) {
        this.visitado = visitado;
        this.visitante = visitante;
    }

    public Jogo(Jogo newJogo){
        this.visitado = newJogo.getVisitado();
        this.visitante = newJogo.getVisitante();
    }

    //metodos override
    @Override
    public Jogo clone(){
        return new Jogo(this);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Jogo resultado = (Jogo)o;
        return this.visitado.equals(resultado.getVisitado()) &&
                this.visitante.equals(resultado.getVisitante());
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "visitado=" + visitado +
                ", visitante=" + visitante +
                '}';
    }

    //metodos especificos
}
