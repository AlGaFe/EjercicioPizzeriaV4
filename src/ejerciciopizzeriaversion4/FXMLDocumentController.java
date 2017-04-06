/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopizzeriaversion4;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alvaro
 */
public class FXMLDocumentController implements Initializable {

    ObservableList<String> tiposTamano = FXCollections.observableArrayList("Pequeña", "Mediana", "Familiar");
    ToggleGroup masa = new ToggleGroup();
    Double precioTotalDouble = 0.0;
    Double multiplicadorTamaño = 1.15;
    Double doublemasa = 0.0;
    Double doublePizza = 0.0;
    String tamaño = "Mediana";
    Double doubleIngrediente = 0.0;
    String StipoPizza = "";
    String sMasa = "";
    Precios precios = new Precios();
    Pizza pizza = new Pizza();
    DecimalFormat formato = new DecimalFormat("0.00");
    @FXML
    private Label label;
    @FXML
    private Label labelPizza;
    @FXML
    private RadioButton original;
    @FXML
    private RadioButton pan;
    @FXML
    private RadioButton finizzima;
    @FXML
    private RadioButton dominosroll;
    @FXML
    private RadioButton cabraroll;
    @FXML
    private TextArea DescripcionMasa1;
    @FXML
    private Label label1;
    @FXML
    private ComboBox<String> desplegableTamaño;
    @FXML
    private Label labelPersonas;
    @FXML
    private Label label2;
    @FXML
    private CheckBox ingredienteAceitunas;
    @FXML
    private CheckBox ingredienteAnchoas;
    @FXML
    private CheckBox ingredienteAtun;
    @FXML
    private CheckBox ingredientebacon;
    @FXML
    private CheckBox ingredienteCeballo;
    @FXML
    private CheckBox ingredienteMaiz;
    @FXML
    private CheckBox ingredientePepperoni;
    @FXML
    private CheckBox ingredientePimientoV;
    @FXML
    private CheckBox ingredienteTofu;
    @FXML
    private CheckBox ingredientePollo;
    @FXML
    private CheckBox ingredienteChampinon;
    @FXML
    private CheckBox ingredienteTernera;
    @FXML
    private CheckBox ingredienteJamonY;
    @FXML
    private CheckBox ingredienteTomate;
    @FXML
    private CheckBox ingredienteJamonS;
    @FXML
    private CheckBox ingredienteCebolla;
    @FXML
    private Label labelMasa;
    @FXML
    private Label MasaElegida;
    @FXML
    private Label tipoPizza;
    @FXML
    private Label labelIngredientes;
    @FXML
    private Label tipoMasa11;
    @FXML
    private Label tipoMasa111;
    @FXML
    private Label labelTamaño;
    @FXML
    private Label pizzaElegida;
    @FXML
    private TextArea seleccionIngredientes;
    @FXML
    private Label tamañoElegido;
    @FXML
    private Label labelTotal;
    @FXML
    private Label precioMasa;
    @FXML
    private Label precioIngredientes;
    @FXML
    private Label precioTamaño;
    @FXML
    private Label precioTotal;
    @FXML
    private Label precioPizza;
    @FXML
    private Button cancelarPedido;
    @FXML
    private TextField TextFieldNombre;
    @FXML
    private Button ButtonGenerarPedido;
    @FXML
    private Button ButtonAjustes;
    @FXML
    private Button ButtonGenerarTicket;
    @FXML
    private ImageView DominosPizza;

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("file:dominos-pizza.png");
        this.DominosPizza.setImage(image);
        desplegableTamaño.setItems(tiposTamano);
        desplegableTamaño.setValue("Mediana");
        listarprecios();
        this.pizza.setUbicacion(Paths.get("C:\\Users\\daw\\Documents\\NetBeansProjects\\EjercicioPizeriaVersion4\\ticketsPizzeria"));
    }

    private void listarprecios() {
        precios.getIngredientes().put("Anchoas", 2.50);
        precios.getIngredientes().put("Aceitunas Negras", 1.00);
        precios.getIngredientes().put("Atún", 1.85);
        precios.getIngredientes().put("Cebolla", 1.00);
        precios.getIngredientes().put("Cebolla Caramelizada", 1.85);
        precios.getIngredientes().put("Champiñón", 2.85);
        precios.getIngredientes().put("Jamón Serrano", 1.85);
        precios.getIngredientes().put("Jamón de York", 1.00);
        precios.getIngredientes().put("Maiz", 1.00);
        precios.getIngredientes().put("Pepperoni", 1.85);
        precios.getIngredientes().put("Pimiento Verde", 2.50);
        precios.getIngredientes().put("Tofu", 3.00);
        precios.getIngredientes().put("Tomate Natural", 1.00);
        precios.getIngredientes().put("Bacon", 1.85);
        precios.getIngredientes().put("Pollo a la Parrilla", 1.85);

        precios.getTiposPizza().put("Margarita", 6.0);
        precios.getTiposPizza().put("Cheesix", 8.0);
        precios.getTiposPizza().put("Pulled Beef", 8.0);
        precios.getTiposPizza().put("Pulled Pork", 8.0);
        precios.getTiposPizza().put("Barbacoa", 7.0);
        precios.getTiposPizza().put("Pecado Carnal", 7.0);
        precios.getTiposPizza().put("Cremozza BBQ", 7.0);
        precios.getTiposPizza().put("Cremozza Estilo Bourbon", 7.0);
        precios.getTiposPizza().put("Carbonara", 7.0);
        precios.getTiposPizza().put("Cabramelizada", 7.0);
        precios.getTiposPizza().put("Pollo a la Parrilla", 7.0);
        precios.getTiposPizza().put("Cuatro Quesos", 7.0);
        precios.getTiposPizza().put("Hawaiana Plus", 7.0);
        precios.getTiposPizza().put("Extravaganzza", 7.0);
        precios.getTiposPizza().put("Pata Negra", 7.0);
        precios.getTiposPizza().put("Campiña", 7.0);
        precios.getTiposPizza().put("Tony Pepperoni", 7.0);

        precios.getMasas().put("Original", 1.0);
        precios.getMasas().put("Pan", 1.0);
        precios.getMasas().put("Finízzima", 1.0);
        precios.getMasas().put("Domino's Roll", 2.0);
        precios.getMasas().put("Cabra & Roll", 2.0);

        precios.getTamanos().put("Pequeña", 1.0);
        precios.getTamanos().put("Mediana", 1.15);
        precios.getTamanos().put("Familiar", 1.30);

    }

    @FXML
    private void seleccionPizza(ActionEvent event) {
        List<String> choices = new ArrayList<>();

        choices.add("Margarita");
        choices.add("Cheesix");
        choices.add("Pulled Beef");
        choices.add("Pulled Pork");
        choices.add("Barbacoa");
        choices.add("Pecado Carnal");
        choices.add("Cremozza BBQ");
        choices.add("Cremozza Estilo Bourbon");
        choices.add("Carbonara");
        choices.add("Cabramelizada");
        choices.add("Pollo a la Parrilla");
        choices.add("Cuatro Quesos");
        choices.add("Hawaiana Plus");
        choices.add("Extravaganzza");
        choices.add("Pata Negra");
        choices.add("Campiña");
        choices.add("Tony Pepperoni");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Margarita", choices);
        dialog.setTitle("Domino's Pizza");
        dialog.setHeaderText("Selección de Pizza");
        dialog.setContentText("Elije tu pizza:");

        Optional<String> result = dialog.showAndWait();
        if (result.get().equals("Margarita")) {
            pizza.setTipo("Margarita");
            doublePizza = this.precios.getTiposPizza().get("Margarita");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Cheesix")) {
            pizza.setTipo("Cheesix");
            doublePizza = this.precios.getTiposPizza().get("Cheesix");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Pulled Beef")) {
            pizza.setTipo("Pulled Beef");
            doublePizza = this.precios.getTiposPizza().get("Pulled Beef");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Pulled Pork")) {
            pizza.setTipo("Pulled Pork");
            doublePizza = this.precios.getTiposPizza().get("Pulled Pork");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Barbacoa")) {
            pizza.setTipo("Barbacoa");
            doublePizza = this.precios.getTiposPizza().get("Barbacoa");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Pecado Carnal")) {
            pizza.setTipo("Pecado Carnal");
            doublePizza = this.precios.getTiposPizza().get("Pecado Carnal");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Cremozza BBQ")) {
            pizza.setTipo("Cremozza BBQ");
            doublePizza = this.precios.getTiposPizza().get("Cremozza BBQ");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Cremozza Estilo Bourbon")) {
            pizza.setTipo("Cremozza Estilo Bourbon");
            doublePizza = this.precios.getTiposPizza().get("Cremozza Estilo Bourbon");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Carbonara")) {
            pizza.setTipo("Carbonara");
            doublePizza = this.precios.getTiposPizza().get("Carbonara");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Cabramelizada")) {
            pizza.setTipo("Cabramelizada");
            doublePizza = this.precios.getTiposPizza().get("Cabramelizada");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Pollo a la Parrilla")) {
            pizza.setTipo("Pollo a la Parrilla");
            doublePizza = this.precios.getTiposPizza().get("Pollo a la Parrilla");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Cuatro Quesos")) {
            pizza.setTipo("Cuatro Quesos");
            doublePizza = this.precios.getTiposPizza().get("Cuatro Quesos");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Hawaiana Plus")) {
            pizza.setTipo("Hawaiana Plus");
            doublePizza = this.precios.getTiposPizza().get("Hawaiana Plus");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Extravaganzza")) {
            pizza.setTipo("Extravaganzza");
            doublePizza = this.precios.getTiposPizza().get("Extravaganzza");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Pata Negra")) {
            pizza.setTipo("Pata Negra");
            doublePizza = this.precios.getTiposPizza().get("Pata Negra");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Campiña")) {
            pizza.setTipo("Campiña");
            doublePizza = this.precios.getTiposPizza().get("Campiña");
            this.labelPizza.setText("Tu elección: " + result.get());
        }
        if (result.get().equals("Tony Pepperoni")) {
            pizza.setTipo("Tony Pepperoni");
            doublePizza = this.precios.getTiposPizza().get("Tony Pepperoni");
            this.labelPizza.setText("Tu elección: " + result.get());
        }

        this.pizzaElegida.setText(this.pizza.getTipo());
        this.precioPizza.setText(formato.format(this.doublePizza) + "€");
        this.precioTotal.setText(formato.format(this.pizza.calcularPrecio()) + "€");
        this.pizza.setPrecioFinal(this.pizza.calcularPrecio());
    }

    @FXML
    private void TipoDeMasa(ActionEvent event) {
        this.original.setToggleGroup(masa);
        this.original.setUserData("Original");
        this.pan.setToggleGroup(masa);
        this.pan.setUserData("Pan");
        this.finizzima.setToggleGroup(masa);
        this.finizzima.setUserData("Finízzima");
        this.dominosroll.setToggleGroup(masa);
        this.dominosroll.setUserData("Domino's Roll");
        this.cabraroll.setToggleGroup(masa);
        this.cabraroll.setUserData("Cabra & Roll");

        doublemasa = this.precios.getMasas().get(this.masa.getSelectedToggle().getUserData());
        if (this.masa.getSelectedToggle().getUserData().equals("Original")) {
            this.DescripcionMasa1.setText("Para aquellos amantes \n del auténtico sabor \n de la pizza Domino's");
            pizza.setMasa("Original");
        }
        if (this.masa.getSelectedToggle().getUserData().equals("Pan")) {
            pizza.setMasa("Pan");
            this.DescripcionMasa1.setText("Al más puro \n estilo Chicago");
        }
        if (this.masa.getSelectedToggle().getUserData().equals("Finízzima")) {
            pizza.setMasa("Finízzima");
            this.DescripcionMasa1.setText("La masa más \n fina y crujiente \n de Domino's");
        }
        if (this.masa.getSelectedToggle().getUserData().equals("Domino's Roll")) {
            pizza.setMasa("Domino's Roll");
            this.DescripcionMasa1.setText("Con delicioso borde \n relleno de queso");
        }
        if (this.masa.getSelectedToggle().getUserData().equals("Cabra & Roll")) {
            pizza.setMasa("Cabra & Roll");
            this.DescripcionMasa1.setText("Borde relleno de \n queso de cabra fundido");
        }

        this.MasaElegida.setText(this.pizza.getMasa());
        this.precioMasa.setText(formato.format(this.doublemasa) + "€");
        this.precioTotal.setText(formato.format(this.pizza.calcularPrecio()) + "€");
        this.pizza.setPrecioFinal(this.pizza.calcularPrecio());
    }

    @FXML
    private void seleccionTamaño(ActionEvent event) {
        String seleccion = desplegableTamaño.getValue();
        if (seleccion.equals("Pequeña")) {
            pizza.setTamano("Pequeña");
            labelPersonas.setText("1");
            multiplicadorTamaño = this.precios.getTamanos().get("Pequeña");
        }
        if (seleccion.equals("Mediana")) {
            pizza.setTamano("Mediana");
            labelPersonas.setText("2");
            multiplicadorTamaño = this.precios.getTamanos().get("Mediana");
        }
        if (seleccion.equals("Familiar")) {
            pizza.setTamano("Familiar");
            labelPersonas.setText("4");
            multiplicadorTamaño = this.precios.getTamanos().get("Familiar");
        }

        this.tamañoElegido.setText(this.pizza.getTamano());
        this.precioTamaño.setText("" + this.multiplicadorTamaño);
        precioTotalDouble = (doublemasa + doublePizza + doubleIngrediente) * multiplicadorTamaño;
        this.precioTotal.setText(formato.format(this.precioTotalDouble) + "€");
        this.pizza.setPrecioFinal(this.pizza.calcularPrecio());
    }

    @FXML
    private void ingredientesExtra(ActionEvent event) {
        doubleIngrediente = 0.0;
        ArrayList<String> ListaIngredientes = new ArrayList<>();
        if (this.ingredienteAceitunas.isSelected()) {
            ListaIngredientes.add("Aceitunas Negras");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Aceitunas Negras");
            this.seleccionIngredientes.appendText("Aceitunas Negras" + "\n");
        }
        if (this.ingredienteAnchoas.isSelected()) {
            ListaIngredientes.add("Anchoas");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Anchoas");
            this.seleccionIngredientes.appendText("Anchoas" + "\n");

        }
        if (this.ingredienteAtun.isSelected()) {
            ListaIngredientes.add("Atún");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Atún");
            this.seleccionIngredientes.appendText("Atún" + "\n");

        }
        if (this.ingredienteCeballo.isSelected()) {
            ListaIngredientes.add("Cebolla");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Cebolla");
            this.seleccionIngredientes.appendText("Cebolla" + "\n");

        }
        if (this.ingredienteCebolla.isSelected()) {
            ListaIngredientes.add("Cebolla Caramelizada");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Cebolla Caramelizada");
            this.seleccionIngredientes.appendText("Cebolla Caramelizada" + "\n");

        }
        if (this.ingredienteChampinon.isSelected()) {
            ListaIngredientes.add("Champiñón");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Champiñón");
            this.seleccionIngredientes.appendText("Champiñón" + "\n");

        }
        if (this.ingredienteJamonS.isSelected()) {
            ListaIngredientes.add("Jamón Serrano");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Jamón Serrano");
            this.seleccionIngredientes.appendText("Jamón Serrano" + "\n");

        }
        if (this.ingredienteJamonY.isSelected()) {
            ListaIngredientes.add("Jamón de York");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Jamón de York");
            this.seleccionIngredientes.appendText("Jamón de York" + "\n");

        }
        if (this.ingredienteMaiz.isSelected()) {
            ListaIngredientes.add("Maiz");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Maiz");
            this.seleccionIngredientes.appendText("Maiz" + "\n");

        }
        if (this.ingredientePepperoni.isSelected()) {
            ListaIngredientes.add("Pepperoni");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Pepperoni");
            this.seleccionIngredientes.appendText("Pepperoni" + "\n");

        }
        if (this.ingredientePimientoV.isSelected()) {
            ListaIngredientes.add("Pimiento Verde");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Pimiento Verde");
            this.seleccionIngredientes.appendText("Pimiento Verde" + "\n");

        }
        if (this.ingredienteTofu.isSelected()) {
            ListaIngredientes.add("Tofu");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Tofu");
            this.seleccionIngredientes.appendText("Tofu" + "\n");

        }
        if (this.ingredienteTomate.isSelected()) {
            ListaIngredientes.add("Tomate Natural");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Tomate Natural");
            this.seleccionIngredientes.appendText("Tomate Natural" + "\n");

        }
        if (this.ingredientebacon.isSelected()) {
            ListaIngredientes.add("Bacon");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Bacon");
            this.seleccionIngredientes.appendText("Bacon" + "\n");

        }
        if (this.ingredientePollo.isSelected()) {
            ListaIngredientes.add("Pollo a la Parrilla");
            doubleIngrediente = doubleIngrediente + this.precios.getIngredientes().get("Pollo a la Parrilla");
            this.seleccionIngredientes.appendText("Pollo a la Parrilla" + "\n");
        }

        this.precioIngredientes.setText(doubleIngrediente + "€");
        this.pizza.setPrecioIngredientes(doubleIngrediente);
        this.seleccionIngredientes.appendText("\n");
        this.seleccionIngredientes.appendText("\n");
        this.precioTotal.setText(formato.format(this.pizza.calcularPrecio()) + "€");
        this.pizza.setPrecioFinal(this.pizza.calcularPrecio());
    }

    @FXML
    private void ResetPedido(ActionEvent event) {
        precioTotalDouble = 0.0;
        multiplicadorTamaño = 1.15;
        doublemasa = 0.0;
        doublePizza = 0.0;
        tamaño = "";
        doubleIngrediente = 0.0;
        StipoPizza = "";
        sMasa = "";

        this.labelPizza.setText("Selecciona tu pizza deseada");

        this.dominosroll.setCache(false);
        this.cabraroll.setCache(false);
        this.finizzima.setCache(false);
        this.original.setCache(false);
        this.pan.setCache(false);

        this.ingredienteAceitunas.setSelected(false);
        this.ingredienteAnchoas.setSelected(false);
        this.ingredienteAtun.setSelected(false);
        this.ingredienteCeballo.setSelected(false);
        this.ingredienteCebolla.setSelected(false);
        this.ingredienteChampinon.setSelected(false);
        this.ingredienteJamonS.setSelected(false);
        this.ingredienteJamonY.setSelected(false);
        this.ingredienteMaiz.setSelected(false);
        this.ingredientePepperoni.setSelected(false);
        this.ingredientePimientoV.setSelected(false);
        this.ingredientePollo.setSelected(false);
        this.ingredienteTernera.setSelected(false);
        this.ingredienteTofu.setSelected(false);
        this.ingredienteTomate.setSelected(false);
        this.ingredientebacon.setSelected(false);

        this.MasaElegida.setText("Tu masa");
        this.pizzaElegida.setText("Tu pizza");
        this.tamañoElegido.setText("Tu tamaño");
        this.seleccionIngredientes.setText("");
        this.precioMasa.setText("");
        this.precioPizza.setText("");
        this.precioIngredientes.setText("");
        this.precioTamaño.setText("");
        this.precioTotal.setText("");

        desplegableTamaño.setValue("Mediana");
        this.labelPersonas.setText("");

        this.TextFieldNombre.setText("");
    }

    @FXML
    private void ActionTextFieldNombre(ActionEvent event) {
    }

    @FXML
    private void ActionButtonGenerarPedido(ActionEvent event) {
        this.pizza.setNombre(this.TextFieldNombre.getText());
    }

    @FXML
    private void ActionButtonAjustes(ActionEvent event) {
        DirectoryChooser elegirDirectorio = new DirectoryChooser();
        File elegirFile = elegirDirectorio.showDialog(new Stage());
        Path elegirRuta = Paths.get(elegirFile.getAbsolutePath());
        File elegirFileDefinitivo = elegirRuta.toFile();
        this.pizza.setUbicacion(elegirFileDefinitivo.toPath());
    }

    @FXML
    private void ActionButtonGenerarTicket(ActionEvent event) {
        this.pizza.generarTicket();
    }

}
