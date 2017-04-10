package Modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/* @author Alvaro */
public class Precios {

    private Map<String, Double> ingredientes = new HashMap<>();
    private Map<String, Double> masas = new HashMap<>();
    private Map<String, Double> tamanos = new HashMap<>();
    private Map<String, Double> tiposPizza = new HashMap<>();

    public Precios() {
    }

    public void listarprecios() {
        this.getIngredientes().put("Anchoas", 2.50);
        this.getIngredientes().put("Aceitunas Negras", 1.00);
        this.getIngredientes().put("Atún", 1.85);
        this.getIngredientes().put("Cebolla", 1.00);
        this.getIngredientes().put("Cebolla Caramelizada", 1.85);
        this.getIngredientes().put("Champiñón", 2.85);
        this.getIngredientes().put("Jamón Serrano", 1.85);
        this.getIngredientes().put("Jamón de York", 1.00);
        this.getIngredientes().put("Maiz", 1.00);
        this.getIngredientes().put("Pepperoni", 1.85);
        this.getIngredientes().put("Pimiento Verde", 2.50);
        this.getIngredientes().put("Tofu", 3.00);
        this.getIngredientes().put("Tomate Natural", 1.00);
        this.getIngredientes().put("Bacon", 1.85);
        this.getIngredientes().put("Pollo a la Parrilla", 1.85);

        this.getTiposPizza().put("Margarita", 6.0);
        this.getTiposPizza().put("Cheesix", 8.0);
        this.getTiposPizza().put("Pulled Beef", 8.0);
        this.getTiposPizza().put("Pulled Pork", 8.0);
        this.getTiposPizza().put("Barbacoa", 7.0);
        this.getTiposPizza().put("Pecado Carnal", 7.0);
        this.getTiposPizza().put("Cremozza BBQ", 7.0);
        this.getTiposPizza().put("Cremozza Estilo Bourbon", 7.0);
        this.getTiposPizza().put("Carbonara", 7.0);
        this.getTiposPizza().put("Cabramelizada", 7.0);
        this.getTiposPizza().put("Pollo a la Parrilla", 7.0);
        this.getTiposPizza().put("Cuatro Quesos", 7.0);
        this.getTiposPizza().put("Hawaiana Plus", 7.0);
        this.getTiposPizza().put("Extravaganzza", 7.0);
        this.getTiposPizza().put("Pata Negra", 7.0);
        this.getTiposPizza().put("Campiña", 7.0);
        this.getTiposPizza().put("Tony Pepperoni", 7.0);

        this.getMasas().put("Original", 1.0);
        this.getMasas().put("Pan", 1.0);
        this.getMasas().put("Finízzima", 1.0);
        this.getMasas().put("Domino's Roll", 2.0);
        this.getMasas().put("Cabra & Roll", 2.0);

        this.getTamanos().put("Pequeña", 1.0);
        this.getTamanos().put("Mediana", 1.15);
        this.getTamanos().put("Familiar", 1.30);

    }

    public void cargarPrecios() {
        try{
        FileChooser elegirArchivo = new FileChooser();
        File seleccionar = elegirArchivo.showOpenDialog(new Stage());
        elegirArchivo.setTitle("Elige el archivo");
        Path direccion = Paths.get(seleccionar.getAbsolutePath());

        String elemento;
        double precio;
        String delimitadorIngred = "€";
        String delimitadorPizzas = "@";
        String delimitadorMasas = "ª";
        String delimitadorTamanos = "º";
        String elementoString;

        try (Stream<String> precios = Files.lines(direccion)) {
            Iterator<String> iterator = precios.iterator();
            while (iterator.hasNext()) {
                elemento = iterator.next();
                if (elemento.contains(delimitadorIngred)) {
                    String[] pedazo = elemento.split(delimitadorIngred);
                    elementoString = pedazo[0];
                    precio = Double.parseDouble(pedazo[1]);
                    this.ingredientes.put(elementoString, precio);

                }
                if (elemento.contains(delimitadorPizzas)) {
                    String[] pedazo = elemento.split(delimitadorPizzas);
                    elementoString = pedazo[0];
                    precio = Double.parseDouble(pedazo[1]);
                    this.tiposPizza.put(elementoString, precio);

                }
                if (elemento.contains(delimitadorMasas)) {
                    String[] pedazo = elemento.split(delimitadorMasas);
                    elementoString = pedazo[0];
                    precio = Double.parseDouble(pedazo[1]);
                    this.masas.put(elementoString, precio);

                }
                if (elemento.contains(delimitadorTamanos)) {
                    String[] pedazo = elemento.split(delimitadorTamanos);
                    elementoString = pedazo[0];
                    precio = Double.parseDouble(pedazo[1]);
                    this.tamanos.put(elementoString, precio);

                }
            }

        } catch (IOException ex) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Domino's Pizza");
            alert.setContentText("Imposible cargar la lista de precios");
        }
           
        
        } catch (Exception e) {
     Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Domino's Pizza");
            alert.setContentText("No has introducido ninguna lista de precios");
    }
    }

    public void setIngredientes(Map<String, Double> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setMasas(Map<String, Double> masas) {
        this.masas = masas;
    }

    public void setTamanos(Map<String, Double> tamaños) {
        this.tamanos = tamaños;
    }

    public void setTiposPizza(Map<String, Double> tiposPizza) {
        this.tiposPizza = tiposPizza;
    }

    public Map<String, Double> getIngredientes() {
        return ingredientes;
    }

    public Map<String, Double> getMasas() {
        return masas;
    }

    public Map<String, Double> getTamanos() {
        return tamanos;
    }

    public Map<String, Double> getTiposPizza() {
        return tiposPizza;
    }

    public Double precioIngrediente(String ingrediente) {
        Double precio;
        precio = ingredientes.get(ingrediente);
        return precio;
    }

    public Double precioMasa(String masa) {
        Double precio;
        precio = masas.get(masa);
        return precio;
    }

    public Double precioTamano(String tamano) {
        Double precio;
        precio = tamanos.get(tamano);
        return precio;
    }

    public Double precioTipo(String tipo) {
        Double precio;
        precio = tiposPizza.get(tipo);
        return precio;
    }
}
