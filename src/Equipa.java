import java.util.HashMap;
import java.util.Map;

public class Equipa {
    //variaveis de instancia
    private Map<Integer,Jogador> jogadores;

    //variaveis de classe

    //getters e setters
    public Map<Integer, Jogador> getJogadores() {
        Map<Integer,Jogador> resultado = new HashMap<>();
        for(Map.Entry<Integer,Jogador> e : jogadores.entrySet()){
            resultado.put(e.getKey(),e.getValue());
            //todo ver clone!
        }
        return resultado;
    }

    public void setJogadores(Map<Integer,Jogador> newJogadores){
        this.jogadores = new HashMap<>();
        for(Map.Entry<Integer,Jogador> e : newJogadores.entrySet()){
            this.jogadores.put(e.getKey(),e.getValue());
            //todo ver clone!
        }
    }

    //construtor
    public Equipa(){
        this.jogadores = new HashMap<>();
    }

    public Equipa(Map<Integer,Jogador> newJogadores){
        this.setJogadores(newJogadores);
    }

    public Equipa(Equipa newEquipa){
        this.jogadores = newEquipa.getJogadores();
    }

    //metodos override
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        Equipa resultado = (Equipa)o;
        return this.jogadores.equals(((Equipa) o).getJogadores());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,Jogador> e : this.jogadores.entrySet()){
            sb.append(e.getKey().toString())
                    .append(": ")
                    .append(e.getValue().toString())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public Equipa clone(){
        return new Equipa(this);
    }

    //metodos especificos
    public double habilidade(){
        return 0;
    }
}
