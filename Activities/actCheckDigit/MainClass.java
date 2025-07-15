package Activities.actCheckDigit;

public class MainClass {
    public static void main(String[] args) {
        Numero numero = new Numero(-1);
        Operaciones op = new Operaciones();

        System.out.println(op.DefinirDigitoVerificador(numero));



    }
}
