package View;

import java.util.List;

/**
 * Interface para a view.
 * @author grupo21
 * @version 1.0
 */

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
     * imprime na tela a parte inferior do menu com um pedido de input do utilizador
     */
    void menuBotIO(String io);

    /**
     * imprime na tela a parte central do menu com um pedido de input do utilizador
     */
    void menuMidIO(String io);

    /**
     * imprime na tela a parte central do menu com um pedido de input do utilizador
     */
    void menuMidIO(List<String> io);

    /**
     * Menu Principal
     */
    void menuPrincipal();

    /**
     * Menu para registo de novo jogador
     */
    void menuRegistarNovoJogador();

    //metodos concretos de class (static methods)
}