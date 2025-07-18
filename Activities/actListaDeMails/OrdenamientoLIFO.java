package Activities.actListaDeMails;

import java.util.List;

public class OrdenamientoLIFO implements TipoOrdenamiento {
    @Override
    public List<Email> ordenarEmails(List<Email> emails) {
        return emails.stream()
                .sorted((e1, e2) -> e2.getFechaDeRecepcion().compareTo(e1.getFechaDeRecepcion()))
                .toList();
    }
}
