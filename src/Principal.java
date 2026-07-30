

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.nacli.controller.EmpleadoController;
import org.nacli.model.Empleado;
import org.nacli.view.EmpleadoView;


public class Principal extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        EmpleadoView vista = new EmpleadoView();
        TabPane raiz = vista.getPanelPestana();
        EmpleadoController controlador = new EmpleadoController(vista);
        Scene escena = new Scene(raiz, 450,600);
        stage.setScene(escena);
        stage.show();
        

    }

}
