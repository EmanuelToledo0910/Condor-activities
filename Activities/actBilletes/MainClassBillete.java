package Activities.actBilletes;

public class MainClassBillete {
    public static void main(String[] args) {
        Billete b1 = new Billete(100);
        Billete b2 = new Billete(100);
        Billete b3 = new Billete(50);
        Billete b4 = new Billete(10);
        Billete b5 = new Billete(10);
        Billete b6 = new Billete(10);
        Caja caja = new Caja();

        caja.AgregarBillete(b1);
        caja.AgregarBillete(b2);
        caja.AgregarBillete(b3);
        caja.AgregarBillete(b4);
        caja.AgregarBillete(b5);
        caja.AgregarBillete(b6);

        // Verifico los billetes en caja tanto antes como despues de pagar la deuda
        caja.getBilletes();
        caja.Pagar(70);
        caja.getBilletes();
        caja.Pagar(220);
        caja.getBilletes();


    }
}
