package Activities.actListaDeMails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Email {
    private String nombre;
    private List<String> Flags = new ArrayList<String>();
    private Date FechaDeRecepcion;

    public Email(String nombre, String Flag, Date FechaDeRecepcion) {
        this.nombre = nombre;
        this.Flags = Arrays.asList(Flag.split(" "));
        this.FechaDeRecepcion = FechaDeRecepcion;

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
