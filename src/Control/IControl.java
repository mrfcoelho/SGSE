package Control;

import Model.IModel;
import View.IView;

public interface IControl {
    //metodos abstratos

    //constantes

    //metodos concretos (default methods)
    void setModel(IModel model);

    void setView(IView view);

    /**
     * Inicia o programa
     */
    void start();

    /**
     * Guarda o estado atual num ficheiro txt
     */
    void salvaEstado();

    /**
     * Carrega estado de um ficheiro txt
     * Se não conseguir carregar, o estado é inicializado vazio
     */
    void carregaEstado();

    //metodos concretos de class (static methods)
}
