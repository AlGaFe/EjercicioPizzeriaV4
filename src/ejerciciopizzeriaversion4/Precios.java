package ejerciciopizzeriaversion4;

import java.util.HashMap;
import java.util.Map;

/* @author Alvaro */
public class Precios {

    private Map<String, Double> ingredientes = new HashMap<>();
    private Map<String, Double> masas = new HashMap<>();
    private Map<String, Double> tamanos = new HashMap<>();
    private Map<String, Double> tiposPizza = new HashMap<>();

    public Precios() {
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
