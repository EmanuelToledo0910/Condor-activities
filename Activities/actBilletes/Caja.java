package Activities.actBilletes;

import java.util.ArrayList;
import java.util.List;

public class Caja {
    private List<Billete> billetes = new ArrayList<Billete>();

    public Caja(List<Billete> billetes) {
        AgregarBillete(billetes);
    }

    public Caja (){}

    public void AgregarBillete(Billete billete) {
        // cuando salta el error al definir la denominacion del billete, se les asigna el valor por defecto 0
        // por lo que esos billetes con valor cero no los agregamos a la caja
        if(billete.getValor() != 0) {
            billetes.add(billete);
        }
    }

    public void AgregarBillete(List<Billete> billetes) {
        for (Billete billete : billetes) {
            if(billete.getValor() != 0){
                AgregarBillete(billete);
            }
        }
    }

    public void getBilletes(){
        String mensaje = "Billetes en caja: ";
        for (Billete billete : billetes) {
            mensaje = mensaje + billete.getValor() + " , ";
        }
        System.out.println(mensaje);
    }

    // Con esta funcion selecciono el billete de mayor denomicacion pero sin que se pase del monto que hay que pagar
    private Billete SeleccionarBilleteAproximado(int monto){
        Billete BilleteAproximado = billetes.get(0);

        //me aseguro de siempre comenzar con el billete de menor denominacion
        for (Billete b : billetes) {
            if(b.getValor() <= BilleteAproximado.getValor()){
                BilleteAproximado = b;
            }
        }

        //considero que el billete mas aproximado debe ser el que mas se acerque al monto sin pasarse
        for (Billete b : billetes) {
            if((b.getValor() <= monto) && (b.getValor() > BilleteAproximado.getValor())){
                BilleteAproximado = b;
            }
        }

        return BilleteAproximado;
    }

    public void Pagar(int monto){
        try{
            if(monto <= 0){
                throw new IllegalArgumentException("monto a pagar invalido");
            }
            List<Billete> BilletesSeleccionados = new ArrayList<>();
            while ((monto > 0) && (!this.billetes.isEmpty())){
                // mientras el monto no sea cero (o menor a cero) se seleccionar el mayor billetere y se restara su valor al monto
                Billete billeteAproximado = SeleccionarBilleteAproximado(monto);
                monto -= billeteAproximado.getValor();
                BilletesSeleccionados.add(billeteAproximado);
                // voy quitando los billetes de la lista original porque sino los vuelve a analiar en cada ciclo
                this.billetes.remove(billeteAproximado);
            }

            if (monto == 0){
                // verifico si la deuda se pago bien y si es asi borro los billetes de la list de la caja
                System.out.println("cuenta pagada");
            }

            else{
                // si resulta que el monto quedo negativo quiere decir que nos pasamos de largo y no se puede pagar
                AgregarBillete(BilletesSeleccionados); // como el monto no se pago devuelvo los billetes a la list original
                BilletesSeleccionados.clear();
                System.out.println("La cuenta no se puede pagar con los billetes en caja");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
