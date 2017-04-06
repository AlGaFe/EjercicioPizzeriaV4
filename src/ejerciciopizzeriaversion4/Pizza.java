package ejerciciopizzeriaversion4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

/* @author Alvaro*/
public class Pizza {

    private Path ubicacion;
    private double precioIngredientes;
    private double PrecioFinal;
    private String masa;
    private String tipo;
    private String tamano;
    private ArrayList<String> listaIngredientes = new ArrayList<>();
    private Precios precios = new Precios();
    private String nombre;

    public Pizza() {

    }

    public void setPrecioFinal(double PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }

    public double getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioIngredientes(double precioIngredientes) {
        this.precioIngredientes = precioIngredientes;
    }

    public double getPrecioIngredientes() {
        return precioIngredientes;
    }

    public void setUbicacion(Path ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Path getUbicacion() {
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

    public void setListaIngredientes(ArrayList<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public ArrayList<String> getListaIngredientes() {
        return listaIngredientes;
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
        if (multiplicadorTamano == null) {
            multiplicadorTamano = 1.15;
        }
        Double precioTipo = precios.precioTipo(tipo);
        if (precioTipo == null) {
            precioTipo = 0.0;
        }
        for (int i = 0; i < this.listaIngredientes.size(); i++) {
            String ingrediente = listaIngredientes.get(i);
            Double precioIngrediente = precios.precioIngrediente(ingrediente);
            if (precioIngrediente == null) {
                precioIngrediente = 0.0;
            }
            precioIngredientes += precioIngrediente;

        }

        precioTotal = multiplicadorTamano * (precioIngredientes + precioMasa + precioTipo);
        return precioTotal;
    }

    public String crearNombreTicket() {
        String nombreTicket;
        String fecha;
        LocalDateTime momento = LocalDateTime.now();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");
        fecha = formato.format(momento);
        nombreTicket = this.nombre + fecha;
        return nombreTicket;
    }

    public void generarTicket() {
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
                out.write("Masa: " + this.masa + "--> Precio " + this.precios.precioMasa(this.masa + "€"));
                out.newLine();
                out.write("Tamaño: " + this.tamano + "--> Precio " + this.precios.precioTamano(this.tamano + "€"));
                out.newLine();
                out.write("Tipo de Pizza: " + this.tipo + "--> Precio " + this.precios.precioTipo(this.tipo + "€"));
                out.newLine();
                out.write("Ingredientes: " + this.listaIngredientes + "--> Precio " + this.precioIngredientes + "€");
            }
        } catch (IOException ex) {

        }
    }
}
