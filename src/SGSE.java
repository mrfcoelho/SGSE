import java.util.ArrayList;
import java.util.List;

public class SGSE {
    //variaveis de instancia

    //variaveis de classe

    //construtor

    //getters e setters

    //metodos override

    //metodos especificos

    /**
     * Criar um novo jogador
     * @return jogador criado
     */
    public Jogador novoJogador(String tipo){
        Jogador resultado;

        switch (tipo){
            case "GuardaRedes":
                resultado = new GuardaRedes();
                break;
            case "Defesa":
                resultado = new Defesa();
                break;
            case "Lateral":
                resultado = new Lateral();
                break;
            case "Medio":
                resultado = new Medio();
                break;
            case "Avancado":
                resultado = new Avancado();
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
    public Equipa novaEquipa(){
        Equipa resultado = new Equipa();
        return resultado;
    }

    /**
     * Associa um jogador a uma equipa
     */
    public void associarJogador(){};

    /**
     * Devolve lista com informação do jogador
     * @return lista com informação
     */
    public List<String> consultarJogador(){
        ArrayList<String> resultado = new ArrayList<>();
        return resultado;
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
}
