package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que modela um jogo.
 * @author grupo21
 * @version 1.0
 */

public class Jogo implements Serializable {
    //variaveis de instancia
    private String equipaCasa;
    private String equipaFora;
    private int scoreCasa;
    private int scoreFora;
    private String data;
    private ArrayList<Integer> jogadoresCasa;
    private ArrayList<String> substituicoesCasa;
    private ArrayList<Integer> jogadoresFora;
    private ArrayList<String> substituicoesFora;

    //variaveis de classe

    //construtor
        //vazio
        /**
         * Construtor vazio para a classe jogo.
         */
        public Jogo(){
            this.equipaCasa = "";
            this.equipaFora = "";
            this.scoreCasa = 0;
            this.scoreFora = 0;
            this.data = "";
            this.jogadoresCasa = new ArrayList<>();
            this.substituicoesCasa = new ArrayList<>();
            this.jogadoresFora = new ArrayList<>();
            this.substituicoesFora = new ArrayList<>();
        }

        //parametrico
        /**
         * Construtor parametrico para a classe jogo.
         * @param equipaCasa nome
         * @param equipaFora nome
         * @param scoreCasa golos
         * @param scoreFora golos
         * @param data do jogo (now por defeito)
         * @param jogadoresCasa lista dos numeros de camisola
         * @param substituicoesCasa numero que sai -> numero que entra
         * @param jogadoresFora lista dos numeros de camisola
         * @param substituicoesFora numero que sai -> numero que entra
         */
        public Jogo(String equipaCasa, String equipaFora, int scoreCasa, int scoreFora, String data,
                    ArrayList<Integer> jogadoresCasa, ArrayList<String> substituicoesCasa,
                    ArrayList<Integer> jogadoresFora, ArrayList<String> substituicoesFora) {
            this.equipaCasa = equipaCasa;
            this.equipaFora = equipaFora;
            this.scoreCasa = scoreCasa;
            this.scoreFora = scoreFora;
            this.data = data;
            this.jogadoresCasa = jogadoresCasa;
            this.substituicoesCasa = substituicoesCasa;
            this.jogadoresFora = jogadoresFora;
            this.substituicoesFora = substituicoesFora;
        }

        //copia
        /**
         * Construtor de copia para a classe jogo.
         * @param newJogo a copiar
         */
        public Jogo(Jogo newJogo){
            this.equipaCasa = newJogo.getEquipaCasa();
            this.equipaFora = newJogo.getEquipaFora();
            this.scoreCasa = newJogo.getScoreCasa();
            this.scoreFora = newJogo.getScoreFora();
            this.data = newJogo.getData();
            this.jogadoresCasa = newJogo.getJogadoresCasa();
            this.substituicoesCasa = newJogo.getSubstituicoesCasa();
            this.jogadoresFora = newJogo.getJogadoresFora();
            this.substituicoesFora = newJogo.getSubstituicoesFora();
        }

    //getters e setters
    /**
     * Metodo getter para a variavel de instancia equipaCasa de um jogo.
     * @return string com o nome da equipaCasa
     */
    public String getEquipaCasa() {
        return this.equipaCasa;
    }

    /**
     * Metodo getter para a variavel de instancia equipaFora de um jogo.
     * @return string com o nome da equipaFora
     */
    public String getEquipaFora() {
        return this.equipaFora;
    }

    /**
     * Metodo getter para a variavel de instancia scoreCasa de um jogo.
     * @return int com numero de golos da equipaCasa
     */
    public int getScoreCasa() {
        return this.scoreCasa;
    }

    /**
     * Metodo getter para a variavel de instancia scoreFora de um jogo.
     * @return int com numero de golos da equipaFora
     */
    public int getScoreFora() {
        return this.scoreFora;
    }

    /**
     * Metodo getter para a variavel de instancia data de um jogo.
     * @return string com a data (YYYY-MM-DD)
     */
    public String getData() {
        return this.data;
    }

    /**
     * Metodo getter para a variavel de instancia jogadoresCasa de um jogo.
     * @return List com os numeros das camisolas dos jogadoresCasa
     */
    public ArrayList<Integer> getJogadoresCasa() {
        return this.jogadoresCasa;
    }

    /**
     * Metodo getter para a variavel de instancia substituicoesCasa de um jogo.
     * @return List com os numeros das substituicoesCasa (numero que sai -> numero que entra)
     */
    public ArrayList<String> getSubstituicoesCasa() {
        return this.substituicoesCasa;
    }

    /**
     * Metodo getter para a variavel de instancia jogadoresFora de um jogo.
     * @return List com os numeros das camisolas dos jogadoresFora
     */
    public ArrayList<Integer> getJogadoresFora() {
        return this.jogadoresFora;
    }

    /**
     * Metodo getter para a variavel de instancia substituicoesFora de um jogo.
     * @return List com os numeros das substituicoesFora (numero que sai -> numero que entra)
     */
    public ArrayList<String> getSubstituicoesFora() {
        return this.substituicoesFora;
    }

    /**
     * Metodo setter para a variavel de instancia equipaCasa de um jogo.
     */
    public void setEquipaCasa(String equipaCasa) {
        this.equipaCasa = equipaCasa;
    }

    /**
     * Metodo setter para a variavel de instancia equipaFora de um jogo.
     */
    public void setEquipaFora(String equipaFora) {
        this.equipaFora = equipaFora;
    }

    /**
     * Metodo setter para a variavel de instancia scoreCasa de um jogo.
     */
    public void setScoreCasa(int scoreCasa) {
        this.scoreCasa = scoreCasa;
    }

    /**
     * Metodo setter para a variavel de instancia scoreFora de um jogo.
     */
    public void setScoreFora(int scoreFora) {
        this.scoreFora = scoreFora;
    }

    /**
     * Metodo setter para a variavel de instancia setData de um jogo.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Metodo setter para a variavel de instancia jogadoresCasa de um jogo.
     */
    public void setJogadoresCasa(ArrayList<Integer> jogadoresCasa) {
        this.jogadoresCasa = jogadoresCasa;
    }

    /**
     * Metodo setter para a variavel de instancia substituicoesCasa de um jogo.
     */
    public void setSubstituicoesCasa(ArrayList<String> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    /**
     * Metodo setter para a variavel de instancia jogadoresFora de um jogo.
     */
    public void setJogadoresFora(ArrayList<Integer> jogadoresFora) {
        this.jogadoresFora = jogadoresFora;
    }

    /**
     * Metodo setter para a variavel de instancia substituicoesFora de um jogo.
     */
    public void setSubstituicoesFora(ArrayList<String> substituicoesFora) {
        this.substituicoesFora = substituicoesFora;
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
        return this.equipaCasa.equals(resultado.getEquipaCasa()) &&
                this.equipaFora.equals(resultado.getEquipaFora()) &&
                this.scoreCasa == resultado.getScoreCasa() &&
                this.scoreFora == resultado.getScoreFora() &&
                this.data.equals(resultado.getData()) &&
                this.jogadoresCasa.equals(resultado.getJogadoresCasa()) &&
                this.substituicoesCasa.equals(resultado.getSubstituicoesCasa()) &&
                this.jogadoresFora.equals(resultado.getJogadoresFora()) &&
                this.substituicoesFora.equals(resultado.getSubstituicoesFora());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jogo:")
                .append(equipaCasa).append(",")
                .append(equipaFora).append(",")
                .append(scoreCasa).append(",")
                .append(scoreFora).append(",")
                .append(data).append(",");

        for(Integer i : this.jogadoresCasa){
            sb.append(i).append(",");
        }
        for(String s : this.substituicoesCasa){
            sb.append(s).append(",");
        }
        for(Integer i : this.jogadoresFora){
            sb.append(i).append(",");
        }
        for(String s : this.substituicoesFora){
            sb.append(s);
        }

        return sb.toString();
    }

    //metodos especificos

    //metodos de classe
    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String equipaCasa = campos[0];
        String equipaFora = campos[1];
        int scoreCasa = Integer.parseInt(campos[2]);
        int scoreFora = Integer.parseInt(campos[3]);
        String data = campos[4];
        ArrayList<Integer> jogadoresCasa = new ArrayList<>();
        ArrayList<String> substituicoesCasa  =new ArrayList<>();
        ArrayList<Integer> jogadoresFora = new ArrayList<>();
        ArrayList<String> substituicoesFora = new ArrayList<>();
        int i=5;
        while(!campos[i].contains("->")){
            jogadoresCasa.add(Integer.parseInt(campos[i++]));
        }

        while(campos[i].contains("->")){
            substituicoesCasa.add(campos[i++]);
        }

        while(!campos[i].contains("->")){
            jogadoresFora.add(Integer.parseInt(campos[i++]));
        }

        while(i< campos.length && campos[i].contains("->")){
            substituicoesFora.add(campos[i++]);
        }

        return new Jogo(equipaCasa, equipaFora, scoreCasa, scoreFora, data,
                jogadoresCasa, substituicoesCasa,
                jogadoresFora, substituicoesFora);
    }
}
