package View;

import java.util.List;

public class View implements IView{
    /**
     * imprime na tela a parte superior do menu
     */
    public void menuTop(){
        System.out.println("**************************************************");
        System.out.println("*                      SGSE                      *");
    }

    /**
     * imprime na tela a parte inferior do menu
     */
    public void menuBottom(){
        System.out.println("*                                                *");
        System.out.println("**************************************************");
    }

    /**
     * Menu Principal
     */
    public void menuPrincipal() {
        System.out.println("*  1 - Registar Novo Jogador                     *");
        System.out.println("*  2 - Registar Nova Equipa                      *");
        System.out.println("*  3 - Associar Jogador                          *");
        System.out.println("*  4 - Consultar Jogador                         *");
        System.out.println("*  5 - Consultar Equipa                          *");
        System.out.println("*  6 - Novo Jogo                                 *");
        System.out.println("*  L - Carregar Estado                           *");
        System.out.println("*  S - Salvar Estado                             *");
        System.out.println("*  X - Terminar                                  *");
    }

    /**
     * imprime na tela a parte central do menu com um pedido de input do utilizador
     */
    public void menuMidIO(String io) {
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.print("* " + io );
        for(int i=0 ; i < 46 - io.length() ; i++){
            System.out.print(" ");
        }
        System.out.println(" *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
    }

    /**
     * Menu para registo de novo jogador
     */
    public void menuRegistarNovoJogador() {
        System.out.println("*                                                *");
        System.out.println("*  Tipo de jogador:                              *");
        System.out.println("*  1 - Guarda-Redes                              *");
        System.out.println("*  2 - Defesa                                    *");
        System.out.println("*  3 - Lateral                                   *");
        System.out.println("*  4 - Médio                                     *");
        System.out.println("*  5 - Avançado                                  *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
    }

    /**
     * Menu para registo de novo jogador
     */
    public void menuConsultarJogador(List<String> resultado) {
        System.out.println("*                                                *");
        for(String s : resultado){
            System.out.print("* " + s );
            for(int i=0 ; i < 46 - s.length() ; i++){
                System.out.print(" ");
            }
            System.out.println(" *");
        }
        System.out.println("*                                                *");
    }


}
