package org.nacli.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class EmpleadoView {

    private TabPane panelPestana = new TabPane();

    //elmenentos (nodos) de el formulario
    private TextField txtId = new TextField();
    private TextField txtNombre = new TextField();
    private ComboBox<String> cbTipoEmpleado = new ComboBox<>();
    private VBox panelCambiante = new VBox(12);

    //elementos de los atributos unicos de las clases hijas
    private TextField txtSalario = new TextField();
    private TextField txtHoras = new TextField();
    private TextField txtCostoHoras = new TextField();
    private TextField txtVentas = new TextField();
    private TextField txtPorcentaje = new TextField();

    //Nodos interactivos: bototones y lista
    private Button btnGuardar = new Button("Guardar Empleado");
    private Button btnCalcular = new Button("Calcular total en nómina");
    private ListView<String> listaNomina = new ListView<>();

    public EmpleadoView() {
        iniciarVista();
    }

    private void iniciarVista() {
        //Formulario Registro --------------------------------------------------------------
        Tab tabRegistro = new Tab("Registro");
        tabRegistro.setClosable(false);

        //layout contenedor para el formulario
        StackPane stackRegistro = new StackPane();
        stackRegistro.setPadding(new Insets(20));

        VBox tarjetaRegistro = new VBox(12);

        txtId.setPromptText("e.g. EMP-001");
        txtNombre.setPromptText("e.j. Alvaro Calderon");
        
        cbTipoEmpleado.getItems().addAll("Asalariado","Por Horas","Comision");
        cbTipoEmpleado.setPromptText("Seleccione una opcion: ");
        cbTipoEmpleado.setMaxWidth(Double.MAX_VALUE);
        
        btnGuardar.setMaxWidth(Double.MAX_VALUE);

        tarjetaRegistro.getChildren().addAll
            (new Label("ID del Empleado:"), txtId, 
            new Label("Nombre del Empleado:"), txtNombre,
            new Label("Tipo de Contrato:"), cbTipoEmpleado,
            panelCambiante, btnGuardar);
        
        stackRegistro.getChildren().add(tarjetaRegistro);
        tabRegistro.setContent(stackRegistro);

        //Pestaña de Lista Resumen ------------------------------------------------------------
        Tab tabResumen = new Tab("Lista resumen");
        tabResumen.setClosable(false);
        StackPane stackResumen = new StackPane();
        stackResumen.setPadding(new Insets(20));
        VBox cardResumen = new VBox(15);
        
        btnCalcular.setMaxWidth(Double.MAX_VALUE);
        cardResumen.getChildren().addAll(new Label("Listado de Nómina"), listaNomina, btnCalcular);
        
        stackResumen.getChildren().add(cardResumen);
        tabResumen.setContent(stackResumen);

        panelPestana.getTabs().addAll(tabRegistro, tabResumen);
    }

    public TabPane getPanelPestana() {
        return panelPestana;
    }

    public void setPanelPestana(TabPane panelPestana) {
        this.panelPestana = panelPestana;
    }
    
    //mostrarAsalariado
    public void mostrarAsalariado(){
        //quitandole los nodos hijos (hoja)
        panelCambiante.getChildren().clear();
        Label lblSalario = new Label("Salario Mensual:");
        txtSalario.setPromptText("Salario mensual: eg. Q.4200.00");
        panelCambiante.getChildren().addAll(lblSalario, txtSalario);
    }
    //mostrarPorHoras
    //mostrarPorComision
    //limpiarPanelCambiante
    
    public void mostrarComisionado (){
        panelCambiante.getChildren().clear();
        Label lblComision = new Label ("salario por comision");
        txtSalario.setPromptText("Salario comision: ej Q250.");
        panelCambiante.getChildren().addAll(lblComision, txtSalario);
    }
    
        public void mostrarPorHoras (){
        panelCambiante.getChildren().clear();
        Label lblHoras = new Label ("salario por hora");
        txtCostoHoras.setPromptText("Salario mensual: ej Q250.00");
        txtHoras.setPromptText("Salario mensual: ej Q250.00");
        panelCambiante.getChildren().addAll(lblHoras, txtHoras);
    }
    

    //-------------------------- SETTERS Y GETTERS

    public TextField getTxtId() {
        return txtId;
    }

    public void setTxtId(TextField txtId) {
        this.txtId = txtId;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public ComboBox<String> getCbTipoEmpleado() {
        return cbTipoEmpleado;
    }

    public void setCbTipoEmpleado(ComboBox<String> cbTipoEmpleado) {
        this.cbTipoEmpleado = cbTipoEmpleado;
    }

    public VBox getPanelCambiante() {
        return panelCambiante;
    }

    public void setPanelCambiante(VBox panelCambiante) {
        this.panelCambiante = panelCambiante;
    }

    public TextField getTxtSalario() {
        return txtSalario;
    }

    public void setTxtSalario(TextField txtSalario) {
        this.txtSalario = txtSalario;
    }

    public TextField getTxtHoras() {
        return txtHoras;
    }

    public void setTxtHoras(TextField txtHoras) {
        this.txtHoras = txtHoras;
    }

    public TextField getTxtCostoHoras() {
        return txtCostoHoras;
    }

    public void setTxtCostoHoras(TextField txtCostoHoras) {
        this.txtCostoHoras = txtCostoHoras;
    }

    public TextField getTxtVentas() {
        return txtVentas;
    }

    public void setTxtVentas(TextField txtVentas) {
        this.txtVentas = txtVentas;
    }

    public TextField getTxtPorcentaje() {
        return txtPorcentaje;
    }

    public void setTxtPorcentaje(TextField txtPorcentaje) {
        this.txtPorcentaje = txtPorcentaje;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(Button btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public void setBtnCalcular(Button btnCalcular) {
        this.btnCalcular = btnCalcular;
    }

    public ListView<String> getListaNomina() {
        return listaNomina;
    }

    public void setListaNomina(ListView<String> listResumen) {
        this.listaNomina = listResumen;
    }

    
    
    

}
