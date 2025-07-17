package Activities.actListaDeMails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class MainClassEmailsSortingSystem {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Email e1 = new Email("MailA","A b", sdf.parse("01/02/2015"));
        Email e2 = new Email("MailB","A",sdf.parse("05/03/2015"));
        Email e3 = new Email("MailC","B",sdf.parse("06/04/2015"));
        Email e4 = new Email("MailD","A B",sdf.parse("08/09/2015"));
        Email e5 = new Email("MailE","C",sdf.parse("07/11/2015"));
        Email e6 = new Email("MailF","A C",sdf.parse("03/12/2015"));


        List<Email> emails = new ArrayList<Email>();
        emails.add(e1);
        emails.add(e2);
        emails.add(e3);
        emails.add(e4);
        emails.add(e5);
        emails.add(e6);

        EmailSortingSystem sistema = new EmailSortingSystem();

       //   sistema.OrdenarEmailsPorFecha(emails, "LIFO");
        sistema.OrdenarEmails(emails, "b-LIFO|!C-FIFO|C-liFO");

    }
}
