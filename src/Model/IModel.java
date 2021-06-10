package Model;

import java.util.List;
import java.util.Map;

/**
 * Interface para o model.
 * @author grupo21
 * @version 1.0
 */

public interface IModel {
    //metodos abstratos

    //constantes

    //metodos concretos (default methods)
    /**
     * Devolve um map com os jogadores existentes
     * @return jogadores (ID no jogo + Jogador)
     */
    Map<Integer, Jogador> getJogadores();

    /**
     * Coloca no model um map de jogadores
     * @param jogadores (ID no jogo + Jogador)
     */
    void setJogadores(Map<Integer, Jogador> jogadores);

    /**
     * Devolve o jogador cujo nome foi passado
     * @param nome do jogador a devolver
     * @return jogador
     * @throws JogadorNotFoundException caso o jogador nao exista
     */
    Jogador getJogador(String nome) throws JogadorNotFoundException;

    /**
     * Adiciona um jogador ao model
     * @param jogador a adicionar
     * @throws JogadorRepetidoException caso o jogador passado já exista no model
     */
    void adicionaJogador(Jogador jogador) throws JogadorRepetidoException;

    /**
     * Associa um jogador a uma equipa
     * @param nomeJogador a associar
     * @param nomeEquipa à qual será associado
     * @throws EquipaNotFoundException caso a equipa nao exista
     * @throws JogadorNotFoundException caso o jogador nao exista
     */
    void associaJogador(String nomeJogador, String nomeEquipa) throws EquipaNotFoundException,JogadorNotFoundException;

    /**
     * Devolve as equipas no model
     * @return map com nome + equipa
     */
    Map<String, Equipa> getEquipas();

    /**
     * Atribui as equipas passadas ao model
     * @param equipas a ser introduzidas
     */
    void setEquipas(Map<String, Equipa> equipas);

    /**
     * Devolve a equipa cujo nome é passado
     * @param nome da equipa a devolver
     * @return equipa
     * @throws EquipaNotFoundException caso a equipa nao exista
     */
    Equipa getEquipa(String nome) throws EquipaNotFoundException;

    /**
     * Adiciona a equipa passada ao model
     * @param nome da equipa a adicionar
     * @throws EquipaRepetidaException caso a equipa passada já exista no model
     */
    void adicionaEquipa(String nome) throws EquipaRepetidaException;

    /**
     * Devolve lista de jogos existentes
     * @return jogos
     */
    List<Jogo> getJogos();

    /**
     * Coloca os jogos passados no model
     * @param jogos a atribuir
     */
    void setJogos(List<Jogo> jogos);

    /**
     * Adiciona um jogo ao model
     * @param jogo a adicionar
     */
    void adicionaJogo(Jogo jogo);

    /**
     * Converte o conteudo do model em texto
     * @return model em formato texto
     */
    String toString();

    //metodos concretos de class (static methods)
}

