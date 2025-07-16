package Activities.actDigitoVerificador;

public class MainClassDigitoVerificador {
    public static void main(String[] args) {
        Numero numero = new Numero(201012341);
        Operaciones op = new Operaciones();

        System.out.println("Digito Verificador: " + op.DefinirDigitoVerificador(numero));



    }
}
