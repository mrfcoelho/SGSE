package Control;

import Model.IModel;
import View.IView;

/**
 * Interface para o control.
 * @author grupo21
 * @version 1.0
 */

public interface IControl {
    //metodos abstratos

    //constantes

    //metodos concretos (default methods)
    /**
     * Atribui o model
     * @param model a atribuir
     */
    void setModel(IModel model);

    /**
     * Atribui a view
     * @param view a atribuir
     */
    void setView(IView view);

    /**
     * Inicia o control
     */
    void start();

    //metodos concretos de class (static methods)
}
