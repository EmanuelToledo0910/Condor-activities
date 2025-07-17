package Activities.actListaDeMails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Email {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static {sdf.setLenient(false);}
    private String nombre;
    private List<String> Flags = new ArrayList<String>();
    private Date FechaDeRecepcion;

    public Email(String nombre, String Flag, String fechaDeRecepcion) {
        this.nombre = nombre;
        this.Flags = Arrays.asList(Flag.split(" "));

        try {
            this.FechaDeRecepcion = sdf.parse(fechaDeRecepcion);
        } catch (ParseException e) {
            System.out.println("Fecha inválida para el email '" + nombre + "': " + fechaDeRecepcion);
            throw new IllegalArgumentException("No se puede crear Email con fecha inválida");
        }

        //paso todos los flags a mayuscula
        for (int i = 0; i < Flags.size(); i++) {
            Flags.set(i, Flags.get(i).toUpperCase());
        }
    }

    public List<String> getFlags() {
        return Flags;
    }

    public Date getFechaDeRecepcion() {
        return FechaDeRecepcion;
    }

    public String getNombre() {
        return nombre;
    }
}
