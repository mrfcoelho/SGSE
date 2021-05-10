package Model;

import java.util.ArrayList;

public class Jogo {
    //variaveis de instancia
    private String EquipaCasa;
    private String EquipaFora;
    private int ScoreCasa;
    private int ScoreFora;
    private String Data;
    private ArrayList<Integer> JogadoresCasa;
    private ArrayList<String> SubstituicoesCasa;
    private ArrayList<Integer> JogadoresFora;
    private ArrayList<String> SubstituicoesFora;

    //variaveis de classe

    //getters e setters


    public String getEquipaCasa() {
        return EquipaCasa;
    }

    public String getEquipaFora() {
        return EquipaFora;
    }

    public int getScoreCasa() {
        return ScoreCasa;
    }

    public int getScoreFora() {
        return ScoreFora;
    }

    public String getData() {
        return Data;
    }

    public ArrayList<Integer> getJogadoresCasa() {
        return JogadoresCasa;
    }

    public ArrayList<String> getSubstituicoesCasa() {
        return SubstituicoesCasa;
    }

    public ArrayList<Integer> getJogadoresFora() {
        return JogadoresFora;
    }

    public ArrayList<String> getSubstituicoesFora() {
        return SubstituicoesFora;
    }

    public void setEquipaCasa(String equipaCasa) {
        EquipaCasa = equipaCasa;
    }

    public void setEquipaFora(String equipaFora) {
        EquipaFora = equipaFora;
    }

    public void setScoreCasa(int scoreCasa) {
        ScoreCasa = scoreCasa;
    }

    public void setScoreFora(int scoreFora) {
        ScoreFora = scoreFora;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setJogadoresCasa(ArrayList<Integer> jogadoresCasa) {
        JogadoresCasa = jogadoresCasa;
    }

    public void setSubstituicoesCasa(ArrayList<String> substituicoesCasa) {
        SubstituicoesCasa = substituicoesCasa;
    }

    public void setJogadoresFora(ArrayList<Integer> jogadoresFora) {
        JogadoresFora = jogadoresFora;
    }

    public void setSubstituicoesFora(ArrayList<String> substituicoesFora) {
        SubstituicoesFora = substituicoesFora;
    }

    //construtor
    public Jogo(){
        this.EquipaCasa = "";
        this.EquipaFora = "";
        this.ScoreCasa = 0;
        this.ScoreFora = 0;
        this.Data = "";
        this.JogadoresCasa = new ArrayList<>();
        this.SubstituicoesCasa = new ArrayList<>();
        this.JogadoresFora = new ArrayList<>();
        this.SubstituicoesFora = new ArrayList<>();
    }

    public Jogo(String EquipaCasa, String EquipaFora, int ScoreCasa, int ScoreFora, String Data,
                ArrayList<Integer> JogadoresCasa, ArrayList<String> SubstituicoesCasa,
                ArrayList<Integer> JogadoresFora, ArrayList<String> SubstituicoesFora) {
        this.EquipaCasa = EquipaCasa;
        this.EquipaFora = EquipaFora;
        this.ScoreCasa = ScoreCasa;
        this.ScoreFora = ScoreFora;
        this.Data = Data;
        this.JogadoresCasa = JogadoresCasa;
        this.SubstituicoesCasa = SubstituicoesCasa;
        this.JogadoresFora = JogadoresFora;
        this.SubstituicoesFora = SubstituicoesFora;
    }

    public Jogo(Jogo newJogo){
        this.EquipaCasa = newJogo.getEquipaCasa();
        this.EquipaFora = newJogo.getEquipaFora();
        this.ScoreCasa = newJogo.getScoreCasa();
        this.ScoreFora = newJogo.getScoreFora();
        this.Data = newJogo.getData();
        this.JogadoresCasa = newJogo.getJogadoresCasa();
        this.SubstituicoesCasa = newJogo.getSubstituicoesCasa();
        this.JogadoresFora = newJogo.getJogadoresFora();
        this.SubstituicoesFora = newJogo.getSubstituicoesFora();
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
        return this.EquipaCasa.equals(resultado.getEquipaCasa()) &&
                this.EquipaFora.equals(resultado.getEquipaFora()) &&
                        this.ScoreCasa == resultado.getScoreCasa() &&
                        this.ScoreFora == resultado.getScoreFora() &&
                        this.Data.equals(resultado.getData()) &&
                        this.JogadoresCasa.equals(resultado.getJogadoresCasa()) &&
                        this.SubstituicoesCasa.equals(resultado.getSubstituicoesCasa()) &&
                        this.JogadoresFora.equals(resultado.getJogadoresFora()) &&
                        this.SubstituicoesFora.equals(resultado.getSubstituicoesFora());
    }

    @Override
    public String toString() {
        return "Model.Jogo{" +
                "EquipaCasa=" + EquipaCasa +
                ", EquipaFora=" + EquipaFora +
                '}';
    }

    //metodos especificos

}
