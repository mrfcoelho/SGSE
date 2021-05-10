import Control.*;
import Model.*;
import View.*;

public class SGSE {
    public static void main(String[] args) {
        //inicializa as interfaces do MVC
        IModel model = new Model();
        IView view = new View();
        IControl control = new Control();

        //inicializa o control
        control.setModel(model);
        control.setView(view);
        control.start();

        //termina o programa
        System.exit(0);
    }
}

//estrutura tipo de uma classe a adotar!

    //variaveis de instancia

    //variaveis de classe

    //construtor
        //vazio

        //parametrico

        //copia

    //getters e setters

    //metodos override

    //metodos abstract

    //metodos especificos



//estrutura tipo de uma interface  a adotar!

    //metodos abstratos

    //constantes

    //metodos concretos (default methods)

    //metodos concretos de class (static methods)