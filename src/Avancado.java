import java.util.Map;

public class Avancado extends Jogador{
    //variaveis de instancia

    //variaveis de classe

    //getters e setters

    //construtor
    public Avancado(){
        super();
    }

    public Avancado(int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca,
                    int remate, int passe, boolean titular, Map<String,String> historial){
        super(velocidade, resistencia, destreza, impulsao, jogoCabeca,
        remate, passe, titular, historial);
    }

    public Avancado(Avancado newAvancado){
        super(newAvancado);
    }

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Avancado resultado = (Avancado)o;
        return this.equals(resultado);
    }

    @Override
    public Avancado clone(){
        return new Avancado(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double habilidade(){
        double resultado = 0.0;
        return resultado;
    }

    //metodos especificos

}
