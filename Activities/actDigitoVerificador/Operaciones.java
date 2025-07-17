package Activities.actDigitoVerificador;

import javax.lang.model.type.NullType;

public class Operaciones {
    public Operaciones (){}

    private Numero InvertirNumero(Numero numero) {
        int num = numero.getValor();
        int ValorResultado = 0;
        while(num > 0){
            int digito = num % 10;
            ValorResultado = ValorResultado * 10 + digito;
            num= (int) num / 10;
        }

        Numero resultado = new Numero(ValorResultado);
        return resultado;
    }

    private Numero MultiplicarPorSecuencia(Numero numero){
        int num = numero.getValor();
        int[] multiplicadores = {2,3,4,5,6,7};

        // paso el numero a string para trabajar mas facil con los indices
        String strNumero = String.valueOf(num);
        int ValorResultado = 0;

        for(int i = 0; i < strNumero.length(); i++){
            // despues de tomar cada indice lo devuelvo a Integer
            int digito = Character.getNumericValue(strNumero.charAt(i));

            // EL i % multiplicadores.length se asegura que el indice de la lista de multiplicadores varie entre 0 y 6
            int multiplicador = multiplicadores[i % multiplicadores.length];
            ValorResultado += digito * multiplicador;
        }
        Numero resultado = new Numero(ValorResultado);
        return resultado;
    }

    private Numero CalcularModuloOnce(Numero numero){
        return new Numero(numero.getValor() % 11);
    }

    private Numero RestarAOnce(Numero numero){
        return new Numero(11 - numero.getValor());
    }

    public int DefinirDigitoVerificador(Numero numero){
        // aca aplique un error de argumento aunque tambien se podria hacer de forma simple tomando el
        // numero.getValor() y pasarlo aplicarle el moduclo para pasar el valor a positivo
        try {
            if (numero.getValor() < 0) {
                throw new IllegalArgumentException("El numero debe ser positivo. \n");
            }
            Numero invertido = InvertirNumero(numero);
            Numero multiplicado = MultiplicarPorSecuencia(invertido);
            Numero mod = CalcularModuloOnce(multiplicado);
            Numero Resultado = RestarAOnce(mod);

            System.out.println("Invertido: " + invertido.getValor());
            System.out.println("Multiplicado: " + multiplicado.getValor());
            System.out.println("Módulo 11: " + mod.getValor());
            System.out.println("Resultado final: " + Resultado.getValor());

            if (Resultado.getValor() == 11) return 0;
            if (Resultado.getValor() == 10) return 1;
            return Resultado.getValor();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
