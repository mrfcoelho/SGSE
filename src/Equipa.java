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
    

    //metodos especificos
    public double habilidade(){
        return 0;
    }
}
