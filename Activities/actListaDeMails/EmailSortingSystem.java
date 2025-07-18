package Activities.actListaDeMails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailSortingSystem {
    private List<Email> emails;
    private List<InstruccionParticular> instrucciones = new ArrayList<>();

    public EmailSortingSystem() {
    }

    // separo las intrucciones en una lista para ir cumpliendolas en orden
    private List<String> DefinirIntrsucciones(String instruccion) {
        // filtro la lista para que no queden instrucciones vacias
        return Arrays.stream(instruccion.split("\\|"))
                .filter(s -> !s.isBlank())
                .toList();
    }

    private void CrearInstrucciones(List<String> instrucciones) {
        for (String inst : instrucciones) {
            inst = inst.trim();

            boolean excluir = inst.charAt(0) == '!';

            String instMayus = inst.toUpperCase();

            // meto una validacion de que la expresion este bien formulada '!' que puede estar o no
            // [A-Z] que valida que haya una letra como flag
            // y el -(FIFO|LIFO) que se asegura que termien en -FIFO o - LIFO
            if (!instMayus.matches("!?[A-Z]-(FIFO|LIFO)")) {
                System.out.println("Instrucción ignorada por formato inválido: " + inst);
                continue;
            }

            // guardo el flag de la intruccion para despuesr pasarlo a mayuscula
            String tipoOrden = excluir ? inst.substring(3, 7) : inst.substring(2, 6);
            char flag = (excluir ? inst.charAt(1) : inst.charAt(0));
            this.instrucciones.add(new InstruccionParticular(excluir, Character.toUpperCase(flag), tipoOrden.toUpperCase()));
        }
    }

    private List<Email> OrdenarEmailsPorFecha(List<Email> emails, String TipoOrden) {
        TipoOrdenamiento estrategia = null;

        if (TipoOrden.equals("FIFO")) {
            estrategia = new OrdenamientoFIFO();
        } else if (TipoOrden.equals("LIFO")) {
            estrategia = new OrdenamientoLIFO();
        }

        return estrategia.ordenarEmails(emails);
    }

    public List<Email> OrdenarEmails (List<Email> Emails, String Instrucciones){
        CrearInstrucciones(DefinirIntrsucciones(Instrucciones));

        List<Email> EmailsOrdenados = new ArrayList<Email>();
        List<Email> ListaTemporal = new ArrayList<Email>();

        for(InstruccionParticular ip : this.instrucciones) {
            String TipoOrden = ip.getTipoOrden();
            Character FlagActual = ip.getFlag();
            Boolean Excluir = ip.getExcluir();

            for(Email email : Emails) {
                boolean contieneFlag = email.getFlags().contains(String.valueOf(FlagActual));
                if (contieneFlag == !Excluir) {
                    ListaTemporal.add(email);
                }
            }

            EmailsOrdenados.addAll(OrdenarEmailsPorFecha(ListaTemporal,TipoOrden));
            Emails.removeAll(ListaTemporal);
            ListaTemporal.clear();
        }

        EmailsOrdenados.addAll(Emails); // agrego los mails que no se abarcan en nignuna instruccion para que queden al final de la lista en el orden que ya estaban
        emails = EmailsOrdenados;
        mostrarListaOrdenada(emails);
        return EmailsOrdenados;
    }

    public void mostrarListaOrdenada(List<Email> Emails){
        System.out.println("La lista ordenada de emails es: ");
        for (Email email : Emails) {
            System.out.println(email.getNombre() + "--> FLAGS: " + email.getFlags() + "--> FECHA: " + email.getFechaDeRecepcion());
        }
    }
}
