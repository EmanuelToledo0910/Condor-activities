package Activities.actBilletes;

public class Billete {
    // Conjunto fijo de valores permitidos para la creación de billetes.
    // No se creó una clase específica ya que las denominaciones son pocas y estáticas.
    // En este ejercicio si cree la clase billete aunque solo tenga valor porque podria tambien agregarse variables como tipo de moneda (peso, euro, dolar, etc)
    int[] denominaciones = {1,5,10,20,50,100};
    private int valor;

    private boolean DefinirDenominacion(int valor){
        for (int i =0; i<denominaciones.length; i++){
            if(denominaciones[i] == valor){
                return true;
            }
        }
        return false;
    }

    public Billete(int valor) {
        // si el numero esta en el array de denomicaciones se lo defino al billete, sino genero el error
        try {if (!DefinirDenominacion(valor)) {
            throw new IllegalArgumentException("El denominacion" + valor + "no pertenece a las definidas \n");
        }
        this.valor = valor;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
};


