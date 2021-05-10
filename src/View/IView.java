package View;

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
     * Menu para registo de novo jogador
     */
    void menuRegistarNovoJogador();

    /**
     * Menu Principal
     */
    void menuPrincipal();

    //metodos concretos de class (static methods)

}