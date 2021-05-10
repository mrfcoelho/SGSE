package Model;

import java.util.HashMap;
import java.util.Map;

public class Model implements IModel{
    //variaveis de instancia
    private Map<Integer,Jogador> jogadores; //lista com todos os jogadores do sitema (ID unico + jogador)
    private Map<String,Equipa> equipas; //lista com todas as equipas do sitema (Nome + equipa)

    //variaveis de classe

    //construtor
        //vazio
        public Model(){
            this.jogadores = new HashMap<>();
            this.equipas = new HashMap<>();
        }

        //parametrico

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
}
