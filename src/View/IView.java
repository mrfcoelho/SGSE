package View;

import java.util.List;

public interface IView {
    //metodos abstratos

    //constantes

    //metodos concretos (default methods)
    /**
     * imprime na tela a parte superior do menu
     */
    void menuTop();

    /**
     * imprime na tela a parte inferior do menu
     */
    void menuBottom();

    /**
     * imprime na tela a parte central do menu com um pedido de input do utilizador
     */
    void menuMidIO(String io);

    /**
     * Menu Principal
     */
    void menuPrincipal();

    /**
     * Menu para registo de novo jogador
     */
    void menuRegistarNovoJogador();

    /**
     * Menu para consulta de um jogador
     */
    void menuConsultarJogador(List<String> resultado);

    //metodos concretos de class (static methods)

}