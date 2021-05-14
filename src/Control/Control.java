package Control;

import Model.*;
import View.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Control implements IControl{
    //variaveis de instancia
    private IModel model;
    private IView view;

    //variaveis de class

    //construtores de class
        //vazio
        public Control(){
        }

        //parametrico

        //copia

    //getters e setters
    public void setModel(IModel model){ this.model = model; }

    public void setView(IView view){ this.view = view; }

    //metodos override

    //metodos abstract

    //metodos especificos
    /**
     * Arranca o programa mostrando a tela e opções iniciais
     */
    public void start(){
        char option;
        String buffer;

        //ciclo do programa
        do{
            //imprime a janela
            this.view.menuTop();
            this.view.menuPrincipal();
            this.view.menuBottom();

            //recebe a opção do utilizador
            buffer = Input.lerString();
            if(buffer.length() > 0){
                option = Character.toUpperCase(buffer.charAt(0));
            }else{
                option = ' ';
            }

            //seleciona o que fazer em função da opção
            switch (option){
                case '1' : registarNovoJogador(); break;
                case '2' : registarNovaEquipa(); break;
                case '3' : associarJogador(); break;
                case '4' : consultarJogador(); break;
                case '5' : consultarEquipa(); break;
                case '6' : novoJogo(); break;
                case 'S' : salvaEstado(); break;
                case 'L' : carregaEstado(); break;
                default: break;
            }
        }while (option != 'X');
    }

    /**
     * Criar um novo jogador
     * @return jogador criado
     */
    public Jogador registarNovoJogador(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuRegistarNovoJogador();
        this.view.menuBottom();

        int tipo = Input.lerInt();

        return registarNovoJogadorTipo(tipo);
    }

    /**
     * Criar um novo jogador sabendo já qual o seu tipo
     * @return jogador criado
     */
    private Jogador registarNovoJogadorTipo(int tipo){
        String[] list = {"Nome: ","NumeroCamisola: ","Velocidade: ","Resistência: ","Destreza: ",
            "Impulsão: ","Cabeça: ","Remate: ","Passe: "};
        ArrayList<String> dados = new ArrayList<>();
        String buffer;
        //imprime a janela
        for(String s : list){
            this.view.menuTop();
            this.view.menuMidIO(s);
            this.view.menuBottom();
            buffer = Input.lerString();
            dados.add(buffer);
        }

        //dados do novo jogador a ser criado (vindos do registo)
        Jogador resultado = null;
        String nome = dados.get(0);
        int numeroCamisola = Integer.parseInt(dados.get(1));
        int velocidade = Integer.parseInt(dados.get(2));
        int resistencia = Integer.parseInt(dados.get(3));
        int destreza = Integer.parseInt(dados.get(4));
        int impulsao = Integer.parseInt(dados.get(5));
        int jogoCabeca = Integer.parseInt(dados.get(6));
        int remate = Integer.parseInt(dados.get(7));
        int passe = Integer.parseInt(dados.get(8));

        //dados do novo jogador a ser criado (default)
        Jogador.Estado estado = Jogador.Estado.SUPLENTE;
        List<String> historial = new ArrayList<>();

        switch (tipo){
            case 1:
                this.view.menuTop();
                this.view.menuMidIO("Elasticidade: ");
                this.view.menuBottom();
                buffer = Input.lerString();
                resultado = new GuardaRedes(nome, numeroCamisola, velocidade, resistencia, destreza,
                impulsao, jogoCabeca, remate, passe, estado, Integer.parseInt(buffer), historial);
                break;
            case 2:
                resultado = new Defesa(nome, numeroCamisola, velocidade, resistencia, destreza,
                        impulsao, jogoCabeca, remate, passe, estado, historial);
                break;
            case 3:
                this.view.menuTop();
                this.view.menuMidIO("Cruzamento: ");
                this.view.menuBottom();
                buffer = Input.lerString();
                resultado = new Lateral(nome, numeroCamisola, velocidade, resistencia, destreza,
                        impulsao, jogoCabeca, remate, passe, estado, Integer.parseInt(buffer), historial);
                break;
            case 4:
                this.view.menuTop();
                this.view.menuMidIO("Recuperacao: ");
                this.view.menuBottom();
                buffer = Input.lerString();
                resultado = new Medio(nome, numeroCamisola, velocidade, resistencia, destreza,
                        impulsao, jogoCabeca, remate, passe, estado, Integer.parseInt(buffer), historial);
                break;
            case 5:
                resultado = new Avancado(nome, numeroCamisola, velocidade, resistencia, destreza,
                        impulsao, jogoCabeca, remate, passe, estado, historial);
                break;
            default:
                break;
        }
        return resultado;
    }

    /**
     * Cria uma nova equipa
     * @return equipa criada
     */
    public Equipa registarNovaEquipa(){
        return new Equipa();
    }

    /**
     * Associa um jogador a uma equipa
     */
    public void associarJogador(){};

    /**
     * Devolve lista com informação do jogador
     * @return lista com informação
     */
    public void consultarJogador(){
        this.view.menuTop();
        this.view.menuMidIO("Indique o nome do jogador:");
        this.view.menuBottom();

        String nome = Input.lerString();
        System.out.println(nome);//?
        List<String> resultado = consultaJogadorNome(nome);
        System.out.println(resultado);//?

        //imprimir resultado
        this.view.menuTop();
        this.view.menuConsultarJogador(resultado);
        this.view.menuBottom();
    }

    private List<String> consultaJogadorNome(String nome) {
        Jogador c = this.model.getJogador(nome);

        List <String> result = new ArrayList<> ();

        if(c!=null) {
            result.add("Nome: " + nome);
            result.add("Numero de camisola: " + String.valueOf(c.getNumeroCamisola()));
            result.add("Velocidade: " + String.valueOf(c.getVelocidade()));
            result.add("Destreza: " + String.valueOf(c.getDestreza()));
            result.add("Impulsão: " + String.valueOf(c.getImpulsao()));
            result.add("Jogo de cabeça: " + String.valueOf(c.getJogoCabeca()));
            result.add("Remate: " + String.valueOf(c.getRemate()));
            result.add("Passe: " + String.valueOf(c.getPasse()));
            result.add("Historial:");
            result.addAll(c.getHistorial());
        }
        return result;
    }

    /**
     * Devolve lista com informação da equipa
     * @return lista com informação
     */
    public List<String> consultarEquipa(){
        ArrayList<String> resultado = new ArrayList<>();
        return resultado;
    }

    /**
     * Cria novo jogo
     */
    public Jogo novoJogo(){
        Jogo resultado = new Jogo();
        return resultado;
    }

    /**
     * Guarda o estado atual num ficheiro txt
     */
    public void salvaEstado(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuMidIO("Nome do ficheiro:");
        this.view.menuBottom();

        String fileName = Input.lerString();

        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(this.model);
            objectOutput.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    /**
     * Carrega estado de um ficheiro txt
     * Se não conseguir carregar, o estado é inicializado vazio
     */
    public void carregaEstado(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuMidIO("Nome do ficheiro [0 - Default]:");
        this.view.menuBottom();

        String fileName = Input.lerString();

        if(!fileName.equals("0")){
            try {
                FileInputStream fin = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fin);
                this.model = new Model((Model) ois.readObject());
                ois.close();
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
                model = new Model();
            }
        }else{
            try {
                Parser.parse(this.model);
            }catch (Exception e){

            }
        }


    }

}
