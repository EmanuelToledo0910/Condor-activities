package Activities.actListaDeMails;

import java.util.List;

public class OrdenamientoFIFO implements TipoOrdenamiento {
    @Override
    public List<Email> ordenarEmails(List<Email> emails) {
        return emails.stream()
                .sorted((e1, e2) -> e1.getFechaDeRecepcion().compareTo(e2.getFechaDeRecepcion()))
                .toList();
    }
}
