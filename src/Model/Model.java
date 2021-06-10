package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements IModel, Serializable {
    //variaveis de instancia
    private Map<Integer,Jogador> jogadores; //lista com todos os jogadores do sitema (ID unico + jogador)
    private Map<String,Equipa> equipas; //lista com todas as equipas do sitema (Nome + equipa)
    private List<Jogo> jogos; //lista com os jogos do sistema

    //variaveis de classe

    //construtor
        //vazio
        public Model(){
            this.jogadores = new HashMap<>();
            this.equipas = new HashMap<>();
            this.jogos = new ArrayList<>();
        }

        //parametrico

        //copia
            public Model(Model model){
                this.jogadores = model.getJogadores();
                this.equipas = model.getEquipas();
                this.jogos = model.getJogos();
            }

    //getters e setters
    public Map<Integer, Jogador> getJogadores() {
        return jogadores;
    }

    public Map<String, Equipa> getEquipas() {
        return equipas;
    }

    public List<Jogo> getJogos(){ return this.jogos; }

    public void setJogadores(Map<Integer, Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas;
    }

    public void setJogos(List<Jogo> jogos) { this.jogos = jogos; }

    //metodos override
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("------Equipas------\n");
        for(Equipa e : this.equipas.values()){
            sb.append(e.toString())
                    .append("\n");
        }
        sb.append("\n------Jogadores------\n");
        for(Jogador j : this.jogadores.values()){
            sb.append(j.toString())
                    .append("\n");
        }
        sb.append("\n------Jogos------\n");
        for(Jogo j : this.jogos){
            sb.append(j.toString())
                    .append("\n");
        }
        return sb.toString() ;
    }

    //metodos abstract

    //metodos especificos
    public Jogador getJogador(String nome) throws JogadorNotFoundException{
        if(this.jogadores.values().stream().anyMatch(j->j.getNome().equals(nome))){
            return this.jogadores.values().stream().filter(j->j.getNome().equals(nome)).findAny().get();
        }else{
            throw new JogadorNotFoundException("Jogador " + nome + " não existe!");
        }
    }

    public void adicionaJogador(Jogador j) throws JogadorRepetidoException {
        if(!this.jogadores.containsValue(j)){
            this.jogadores.put(j.getId(),j);
        }else{
            throw new JogadorRepetidoException("Já existe no sistema um jogador igual!");
        }
    }

    public void associaJogador(String nomeJogador, String nomeEquipa)
            throws EquipaNotFoundException,JogadorNotFoundException{
        if(this.jogadores.values().stream().anyMatch(j->j.getNome().equals(nomeJogador))) {
            Jogador j = this.jogadores.values().stream().filter(x -> x.getNome().equals(nomeJogador))
                    .findFirst().get();
            if (this.equipas.containsKey(nomeEquipa)) {
                j.atualizaHistorial(nomeEquipa);
                this.equipas.get(nomeEquipa).insereJogador(j);
            } else {
                throw new EquipaNotFoundException("Equipa " + nomeEquipa + " não existe!");
            }
        }else {
                throw new JogadorNotFoundException("Jogador " + nomeJogador + " não existe!");
        }
    }

    public Equipa getEquipa(String nome) throws EquipaNotFoundException{
        if(this.equipas.containsKey(nome)){
            return this.equipas.get(nome);
        }else{
            throw new EquipaNotFoundException("Equipa " + nome + " não existe!");
        }
    }

    public void adicionaEquipa(String nome) throws EquipaRepetidaException {
        if(!this.equipas.containsKey(nome)){
            Equipa e = new Equipa();
            e.setNome(nome);
           this.equipas.put(nome,e);
        }else{
            throw new EquipaRepetidaException("Já existe no sistema uma equipa igual!");
        }
    }

    public void adicionaJogo(Jogo jogo){
            this.jogos.add(jogo);
    }

    //metodos de classe
}
