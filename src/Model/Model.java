package Model;

import java.util.HashMap;
import java.util.Map;

public class Model implements IModel{
    //variaveis de instancia
    private Map<Integer,Jogador> jogadores; //lista com todos os jogadores do sitema (ID unico + jogador)
    private Map<String,Equipa> equipas; //lista com todas as equipas do sitema (Nome + equipa)
    // todo private List<Jogo> jogos;

    //variaveis de classe

    //construtor
        //vazio
        public Model(){
            this.jogadores = new HashMap<>();
            this.equipas = new HashMap<>();
        }

        //parametrico


    /**
     * Metodo que cria um Model a partir do ficheiro de texto disponibilizado pelos docentes.
     */
    public Model (String filepath) {


    }

    //copia
        public Model(Model model){
            this.jogadores = model.getJogadores();
            this.equipas = model.getEquipas();
        }

    //getters e setters

    public Map<Integer, Jogador> getJogadores() {
        return jogadores;
    }

    public Map<String, Equipa> getEquipas() {
        return equipas;
    }

    public void setJogadores(Map<Integer, Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    //metodos override


    //metodos abstract

    //metodos especificos
    public Jogador getJogador(String nome){
        Jogador resultado = null;
        //resultado = this.jogadores.values().stream().filter(x->x.getNome().equals(nome)).collect();
        for(Jogador j : this.jogadores.values()){
            if(j.getNome().equals(nome)){
                //?System.out.println("Found!!!");
                resultado = j.clone();
                break;
            }
        }
        return resultado;
    }
}
