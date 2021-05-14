package Model;

import java.util.Map;

public interface IModel {
    //metodos abstratos

    //constantes

    //metodos concretos (default methods)
    Map<Integer, Jogador> getJogadores();

    Jogador getJogador(String nome);

    Map<String, Equipa> getEquipas();

    void setJogadores(Map<Integer, Jogador> jogadores);

    void setEquipas(Map<String, Equipa> equipas);

    //metodos concretos de class (static methods)
}

