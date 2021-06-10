package Control;

import Model.*;
import View.IView;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Interface para o control.
 * @author grupo21
 * @version 1.0
 */

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
        Scanner input = new Scanner(System.in);

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
                case '1' : registarNovoJogador(); input.nextLine(); break;
                case '2' : registarNovaEquipa(); input.nextLine(); break;
                case '3' : associarJogador();  input.nextLine(); break;
                case '4' : consultarJogador();  input.nextLine(); break;
                case '5' : consultarEquipa();  input.nextLine(); break;
                case '6' : novoJogo();  input.nextLine(); break;
                case 'S' : salvaEstado();  input.nextLine(); break;
                case 'L' : carregaEstado();  input.nextLine(); break;
                case 'T': System.out.println(this.model.toString());
                default: break;
            }
        }while (option != 'X');
        input.close();
    }

    /**
     * Criar um novo jogador
     */
    private void registarNovoJogador(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuRegistarNovoJogador();
        this.view.menuBottom();

        int tipo = Input.lerInt();

        Jogador resultado = registarNovoJogadorTipo(tipo);

        try{
            this.model.adicionaJogador(resultado);

            //imprime o resultado
            this.view.menuTop();
            this.view.menuMidIO("Jogador registado com sucesso!");
            this.view.menuBottom();
        }catch (JogadorRepetidoException e){
            this.view.menuTop();
            this.view.menuMidIO(e.getMessage());
            this.view.menuBottom();
        }
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
        int v=0;
        boolean ok=true;
        //imprime a janela
        for(String s : list){
            while(ok) {
            this.view.menuTop();
            this.view.menuMidIO(s);
            this.view.menuBottom();
            buffer = Input.lerString();
            v=Integer.parseInt(buffer);
            if(v>0 && v<100) {
            dados.add(buffer);
            ok=false;
            }
            else {
                this.view.menuTop();
                this.view.menuMidIO("O atributo do jogador de ser maior 0 e menor que 100");
                this.view.menuBottom();
            }
            }
            ok=true;
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
     */
    private void registarNovaEquipa(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuMidIO("Nome da equipa: ");
        this.view.menuBottom();

        String nome = Input.lerString();

        try{
            this.model.adicionaEquipa(nome);

            //imprime o resultado
            this.view.menuTop();
            this.view.menuMidIO("Equipa registada com sucesso!");
            this.view.menuBottom();
        }catch (EquipaRepetidaException e){
            this.view.menuTop();
            this.view.menuMidIO(e.getMessage());
            this.view.menuBottom();
        }
    }

    /**
     * Associa um jogador a uma equipa
     */
    private void associarJogador(){
        //imprime a janela
        this.view.menuTop();
        this.view.menuMidIO("Nome do jogador a associar: ");
        this.view.menuBottom();

        String nomeJogador = Input.lerString();

        //imprime a janela
        this.view.menuTop();
        this.view.menuMidIO("Nome da equipa a associar: ");
        this.view.menuBottom();

        String nomeEquipa = Input.lerString();

        try {
            this.model.associaJogador(nomeJogador, nomeEquipa);

            //imprime o resultado
            this.view.menuTop();
            this.view.menuMidIO(nomeJogador + " associado com sucesso a " + nomeEquipa + "!");
            this.view.menuBottom();
        }catch (JogadorNotFoundException | EquipaNotFoundException e1){
            this.view.menuTop();
            this.view.menuMidIO(e1.getMessage());
            this.view.menuBottom();
        }
    }

    /**
     * Devolve lista com informação do jogador
     */
    private void consultarJogador(){
        this.view.menuTop();
        this.view.menuMidIO("Indique o nome do jogador:");
        this.view.menuBottom();

        String nome = Input.lerString();
        try {
            Jogador c = this.model.getJogador(nome);
            List<String> resultado = c.consultaJogador();

            //imprimir resultado
            this.view.menuTop();
            this.view.menuMidIO(resultado);
            this.view.menuBottom();
        }catch (JogadorNotFoundException e){
            //imprimir excepções
            this.view.menuTop();
            this.view.menuMidIO(e.getMessage());
            this.view.menuBottom();
        }
    }

    /**
     * Devolve lista com informação da equipa
     */
    private void consultarEquipa(){
        this.view.menuTop();
        this.view.menuMidIO("Indique o nome da Equipa: ");
        this.view.menuBottom();

        String nome = Input.lerString();

        try {
            Equipa c = this.model.getEquipa(nome);

            List<String> resultado = new ArrayList<> ();

            resultado.add("Nome: " + nome);
            resultado.add("");
            resultado.add("Jogadores:");
            for(Jogador j : c.getJogadores().values()){
                resultado.add(j.getNumeroCamisola() + " - " + j.getNome());
            }
            resultado.add("");
            resultado.add("Habilidade total: " + c.habilidade());

            //imprimir resultado
            this.view.menuTop();
            this.view.menuMidIO(resultado);
            this.view.menuBottom();
        }catch (EquipaNotFoundException e){
            //imprimir excepções
            this.view.menuTop();
            this.view.menuMidIO(e.getMessage());
            this.view.menuBottom();
        }
    }

    /**
     * Cria novo jogo
     */
    private void novoJogo(){
        String equipaCasaNome;
        Map<Integer,Jogador> equipaCasaTodos;
        Map<Integer,Jogador> equipaCasaTitulares = new HashMap<>();
        Map<Integer,Jogador> equipaCasaSuplentes;
        List<String> equipaCasaListaSubstituicoes = new ArrayList<>();
        int equipaCasaSubstituicoes;
        double equipaCasaHabilidade = 0;

        String equipaForaNome;
        Map<Integer,Jogador> equipaForaTodos;
        Map<Integer,Jogador> equipaForaTitulares = new HashMap<>();
        Map<Integer,Jogador> equipaForaSuplentes;
        List<String> equipaForaListaSubstituicoes = new ArrayList<>();
        int equipaForaSubstituicoes;
        double equipaForaHabilidade = 0;

        boolean ok;
        int scoreCasa = 0;
        int scoreFora = 0;
        String data ;

        ArrayList<String> temp = new ArrayList<>();
        String errors = "";
        String substituicaoTemp = "";
        boolean flag = true;
        int aux;

        //data
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        data = dtf.format(LocalDateTime.now());

        //equipaCasa
        this.view.menuTop();
        this.view.menuMidIO("Indique o nome da Equipa da casa: ");
        this.view.menuBottom();
        equipaCasaNome = Input.lerString();
        try {
            equipaCasaTodos = this.model.getEquipa(equipaCasaNome).getJogadores();
            equipaCasaHabilidade = this.model.getEquipa(equipaCasaNome).habilidade();
            equipaCasaSuplentes = new HashMap<>(equipaCasaTodos);
            equipaCasaTitulares = new HashMap<>();

            while(flag){
                temp.clear();
                temp.add(equipaCasaNome);
                temp.add("");
                temp.add("Titulares:");
                for(Jogador j : equipaCasaTitulares.values()){
                    temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                }
                temp.add("");
                temp.add("Suplentes:");
                for(Jogador j : equipaCasaSuplentes.values()){
                    temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                }
                temp.add("");
                temp.add("Número dos jogadores titulares: ");
                temp.add("[0 - sair com a equipa atual]");

                this.view.menuTop();
                this.view.menuMidIO(temp);
                this.view.menuBotIO(errors);
                errors = "";

                aux = Input.lerInt();
                if(aux==0 && equipaCasaTitulares.keySet().size()==11){
                    flag=false;
                    temp.clear();
                    temp.add(equipaCasaNome);
                    temp.add("");
                    temp.add("Titulares:");
                    for(Jogador j : equipaCasaTitulares.values()){
                        temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                    }
                    temp.add("");
                    temp.add("Suplentes:");
                    for(Jogador j : equipaCasaSuplentes.values()){
                        temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                    }
                }else{
                    if(!equipaCasaTodos.containsKey(aux)){
                        errors = "Número inválido!";
                    }else if(equipaCasaTitulares.keySet().size()==11){
                        errors = "Só pode ter 11 titulares!";
                    }else{
                        equipaCasaTitulares.put(aux,equipaCasaTodos.get(aux));
                        equipaCasaSuplentes.remove(aux);
                    }
                }
            }
            while(ok){
            this.view.menuTop();
            this.view.menuMidIO(temp);
            this.view.menuBotIO("Total de substituições a fazer: ");
            equipaCasaSubstituicoes = Input.lerInt();
            if(equipaCasaSubstituicoes>3) {
                this.view.menuTop();
                this.view.menuMidIO("Não é possivel realizar mais de 3 substituições");
                this.view.menuBottom();
            } 
            else{
                ok=false;
            }
            }

            flag = true;
            aux = 1;
            errors = "Número dos jogadores [out->in]:";

            while(flag && equipaCasaSubstituicoes>0){
                this.view.menuTop();
                this.view.menuMidIO(temp);
                this.view.menuBotIO(aux + "/" + equipaCasaSubstituicoes + " - " + errors);
                substituicaoTemp = Input.lerString();
                String[] substituicaoTempPartido = substituicaoTemp.split("->");

                if(substituicaoTempPartido.length!=2){
                    errors = "Substituição mal introduzida!";
                }else if(!equipaCasaTitulares.containsKey(Integer.parseInt(substituicaoTempPartido[0]))){
                    errors = "Jogador a sair não é titular!";
                }else if(!equipaCasaSuplentes.containsKey(Integer.parseInt(substituicaoTempPartido[1]))){
                    errors = "Jogador a entrar não é suplente!";
                }else{
                    if(aux==equipaCasaSubstituicoes)
                        flag = false;
                    equipaCasaListaSubstituicoes.add(substituicaoTemp);
                    aux++;
                    errors = "Número dos jogadores [out->in]:";
                }
            }

            //equipaFora
            ok=true;
            while(ok) {
            this.view.menuTop();
            this.view.menuMidIO("Indique o nome da Equipa da fora: ");
            this.view.menuBottom();
            equipaForaNome = Input.lerString();
                if(equipaForaNome.equals(equipaCasaNome)) {
                    this.view.menuTop();
                    this.view.menuMidIO("Não é possivel realizar um jogos com a mesma equipa");
                    this.view.menuBottom(); 
                }
                else{
                    ok=false;
                }
            }

            errors = "";
            flag=true;

            try {
                equipaForaTodos = this.model.getEquipa(equipaForaNome).getJogadores();
                equipaForaHabilidade = this.model.getEquipa(equipaForaNome).habilidade();
                equipaForaSuplentes = new HashMap<>(equipaForaTodos);
                equipaForaTitulares = new HashMap<>();

                while(flag){
                    temp.clear();
                    temp.add(equipaForaNome);
                    temp.add("");
                    temp.add("Titulares:");
                    for(Jogador j : equipaForaTitulares.values()){
                        temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                    }
                    temp.add("");
                    temp.add("Suplentes:");
                    for(Jogador j : equipaForaSuplentes.values()){
                        temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                    }
                    temp.add("");
                    temp.add("Número dos jogadores titulares: ");
                    temp.add("[0 - sair com a equipa atual]");

                    this.view.menuTop();
                    this.view.menuMidIO(temp);
                    this.view.menuBotIO(errors);
                    errors = "";

                    aux = Input.lerInt();
                    if(aux==0 && equipaForaTitulares.keySet().size()==11){
                        flag=false;
                        temp.clear();
                        temp.add(equipaForaNome);
                        temp.add("");
                        temp.add("Titulares:");
                        for(Jogador j : equipaForaTitulares.values()){
                            temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                        }
                        temp.add("");
                        temp.add("Suplentes:");
                        for(Jogador j : equipaForaSuplentes.values()){
                            temp.add(j.getClass().getSimpleName() + " - " + j.getNome() + " " + j.getNumeroCamisola()) ;
                        }
                    }else{
                        if(!equipaForaTodos.containsKey(aux)){
                            errors = "Número inválido!";
                        }else if(equipaForaTitulares.keySet().size()==11){
                            errors = "Só pode ter 11 titulares!";
                        }else{
                            equipaForaTitulares.put(aux,equipaForaTodos.get(aux));
                            equipaForaSuplentes.remove(aux);
                        }
                    }
                }
                ok=true;
                while(ok){
                this.view.menuTop();
                this.view.menuMidIO(temp);
                this.view.menuBotIO("Total de substituições a fazer: ");
                equipaForaSubstituicoes = Input.lerInt();
                if(equipaForaSubstituicoes>3) {
                    this.view.menuTop();
                    this.view.menuMidIO("Não é possivel realizar mais de 3 substituições");
                    this.view.menuBottom();
                    } 
                    else{
                        ok=false;
                    }
                }
                flag = true;
                aux = 1;
                errors = "Número dos jogadores [out->in]:";

                while(flag && equipaForaSubstituicoes>0){
                    this.view.menuTop();
                    this.view.menuMidIO(temp);
                    this.view.menuBotIO(aux + "/" + equipaForaSubstituicoes + " - " + errors);
                    substituicaoTemp = Input.lerString();
                    String[] substituicaoTempPartido = substituicaoTemp.split("->");

                    if(substituicaoTempPartido.length!=2){
                        errors = "Substituição mal introduzida!";
                    }else if(!equipaForaTitulares.containsKey(Integer.parseInt(substituicaoTempPartido[0]))){
                        errors = "Jogador a sair não é titular!";
                    }else if(!equipaForaSuplentes.containsKey(Integer.parseInt(substituicaoTempPartido[1]))){
                        errors = "Jogador a entrar não é suplente!";
                    }else{
                        if(aux==equipaForaSubstituicoes)
                            flag = false;
                        equipaForaListaSubstituicoes.add(substituicaoTemp);
                        aux++;
                        errors = "Número dos jogadores [out->in]:";
                    }
                }

                //calcula o resultado
                int win = (int)(5 * Math.random());
                int loose = (int)(5 * Math.random());
                if(equipaCasaHabilidade*0.6>equipaForaHabilidade*0.4){
                    scoreCasa = win;
                    scoreFora = loose;
                    StringBuilder mens = new StringBuilder();
                    mens.append(equipaCasaNome).append(":").append(scoreCasa).append("-").append(scoreFora).append(":").append(equipaForaNome);
                    this.view.menuTop();
                    this.view.menuMidIO(mens.toString());
                    this.view.menuBottom();
                }else{
                    scoreCasa = loose;
                    scoreFora = win;
                    StringBuilder mens = new StringBuilder();
                    mens.append(equipaCasaNome).append(":").append(scoreCasa).append("-").append(scoreFora).append(":").append(equipaForaNome);
                    this.view.menuTop();
                    this.view.menuMidIO(mens.toString());
                    this.view.menuBottom();
                }
                

                //adicionar novo jogo ao model
                this.model.adicionaJogo(new Jogo(equipaCasaNome, equipaForaNome, scoreCasa, scoreFora, data,
                        new ArrayList<>(equipaCasaTitulares.keySet()),
                        new ArrayList<>(equipaCasaListaSubstituicoes),
                        new ArrayList<>(equipaForaTitulares.keySet()),
                        new ArrayList<>(equipaForaListaSubstituicoes)));
            }catch (EquipaNotFoundException e){
                //imprimir excepções
                this.view.menuTop();
                this.view.menuMidIO(e.getMessage());
                this.view.menuBottom();
            }
        }catch (EquipaNotFoundException e){
            //imprimir excepções
            this.view.menuTop();
            this.view.menuMidIO(e.getMessage());
            this.view.menuBottom();
        }
    }

    /**
     * Guarda o estado atual num ficheiro txt
     */
    private void salvaEstado(){
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

            //imprime o resultado
            this.view.menuTop();
            this.view.menuMidIO("Estado salvo com sucesso!");
            this.view.menuBottom();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    /**
     * Carrega estado de um ficheiro txt
     * Se não conseguir carregar, o estado é inicializado vazio
     */
    private void carregaEstado(){
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
        //imprime o resultado
        this.view.menuTop();
        this.view.menuMidIO("Estado carregado com sucesso!");
        this.view.menuBottom();
    }

}
