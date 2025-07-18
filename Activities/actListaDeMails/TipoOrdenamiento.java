package Activities.actListaDeMails;

import java.util.List;

public interface TipoOrdenamiento {
    // aplique una interface porque en un futuro podrian implementarse nuevos tipos de ordenamiento
    List<Email> ordenarEmails(List<Email> emails);
}
