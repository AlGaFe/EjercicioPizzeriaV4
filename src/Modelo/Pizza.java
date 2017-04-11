package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.scene.control.Alert;

/* @author Alvaro*/
public class Pizza {

    private File ubicacion;
    private double precioIngredientes;
    private String masa;
    private String tipo;
    private String tamano;
    private Set<String> ListaIngredientes = new HashSet<>();
    private Precios precios;
    private String nombre;
    DecimalFormat formato = new DecimalFormat("0.00");
    String ingrediente;
    Double precioIngrediente;

    public Pizza() {

    }

    public void setPrecioIngredientes(double precioIngredientes) {
        this.precioIngredientes = precioIngredientes;
    }

    public double getPrecioIngredientes() {
        return precioIngredientes;
    }

    public void setUbicacion(File ubicacion) {
        this.ubicacion = ubicacion;
    }

    public File getUbicacion() {
        return ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setListaIngredientes(Set<String> ListaIngredientes) {
        this.ListaIngredientes = ListaIngredientes;
    }

    public Set<String> getListaIngredientes() {
        return ListaIngredientes;
    }

    public void setPrecios(Precios precios) {
        this.precios = precios;
    }

    public String getMasa() {
        return masa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public Precios getPrecios() {
        return precios;
    }

    public Double calcularPrecio() {
        Double precioTotal;
        Double precioIngredientes = 0.0;

        Double precioMasa = precios.precioMasa(masa);
        if (precioMasa == null) {
            precioMasa = 0.0;
        }
        Double multiplicadorTamano = precios.precioTamano(tamano);
        if (multiplicadorTamano == null || multiplicadorTamano == 0.0) {
            multiplicadorTamano = 1.15;
        }
        Double precioTipo = precios.precioTipo(tipo);
        if (precioTipo == null) {
            precioTipo = 0.0;
        }
        Iterator<String> lI = ListaIngredientes.iterator();
        while (lI.hasNext()) {
            ingrediente = lI.next();
        
        precioIngrediente = precios.precioIngrediente(ingrediente);
        }
//        for (int i = 0; i < this.listaIngredientes.size(); i++) {
////            String ingrediente = listaIngredientes.get(i);
//             = precios.precioIngrediente(ingrediente);
        if (precioIngrediente == null) {
            precioIngrediente = 0.0;
        }
        precioIngredientes += precioIngrediente;
        
//        }
        precioTotal = multiplicadorTamano * (precioIngredientes + precioMasa + precioTipo);
        return precioTotal;
    }

    public String crearNombreTicket() {
        String nombreTicket;
        String fecha;
        LocalDateTime momento = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        fecha = formato.format(momento);
        nombreTicket = this.nombre + fecha;
        return nombreTicket;
    }

    public void generarTicket() {
        try{
        String nombreTicket = crearNombreTicket();
        try {
            File directorio = new File(this.ubicacion + "\\" + nombreTicket + ".txt");
            Path path = Paths.get(directorio.toURI());
            if (directorio.exists() == false) {
                directorio.createNewFile();
            }
            try (BufferedWriter out = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
                out.newLine();
                out.write("Pedido: " + this.nombre);
                out.newLine();
                out.write("Masa: " + this.masa + "--> Precio " + formato.format(this.precios.precioMasa(masa)) + " €");
                out.newLine();
                out.write("Tamaño: " + this.tamano + "--> Precio " + formato.format(this.precios.precioTamano(tamano)) + " €");
                out.newLine();
                out.write("Tipo de Pizza: " + this.tipo + "--> Precio " + formato.format(this.precios.precioTipo(tipo)) + " €");
                out.newLine();
                out.write("Ingredientes: " + this.ListaIngredientes + "--> Precio " + formato.format(this.precioIngredientes) + " €");
                out.newLine();
                out.write("-----------------------------------------------------------------------------------------");
                out.newLine();
                out.write("Precio total final -------------------------------------------->" + formato.format(this.calcularPrecio()) + " €");
            }
        } catch (IOException ex) {

        }
    }catch (Exception e) {
     Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Domino's Pizza");
            alert.setContentText("No has introducido ninguna ruta para tu ticket, tu ticket se creará en la ruta por defecto");
    }
    }
}
