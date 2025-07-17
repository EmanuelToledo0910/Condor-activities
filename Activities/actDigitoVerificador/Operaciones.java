package Activities.actDigitoVerificador;

import javax.lang.model.type.NullType;

public class Operaciones {
    // en un principio pense en una clase 'Numero' con un valor pero en tema de mantenibilidad era inncesaria
    // mas pensando que era tener un objeto numero con un valor al que habia que acceder a cada rato
    public Operaciones (){}

    private int InvertirNumero(int numero) {
        int ValorResultado = 0;
        while(numero > 0){
            int digito = numero % 10;
            ValorResultado = ValorResultado * 10 + digito;
            numero= (int) numero / 10;
        }

        return ValorResultado;
    }

    private int MultiplicarPorSecuencia(int numero){
        int[] multiplicadores = {2,3,4,5,6,7};

        // paso el numero a string para trabajar mas facil con los indices
        String strNumero = String.valueOf(numero);
        int ValorResultado = 0;

        for(int i = 0; i < strNumero.length(); i++){
            // despues de tomar cada indice lo devuelvo a Integer
            int digito = Character.getNumericValue(strNumero.charAt(i));

            // EL i % multiplicadores.length se asegura que el indice de la lista de multiplicadores varie entre 0 y 6
            int multiplicador = multiplicadores[i % multiplicadores.length];
            ValorResultado += digito * multiplicador;
        }

        return ValorResultado;
    }

    private int CalcularModuloOnce(int numero){
        return numero % 11;
    }

    private int RestarAOnce(int numero){
        return 11 -numero;
    }

    public int DefinirDigitoVerificador(int numero){
        // aca aplique un error de argumento aunque tambien se podria hacer de forma simple tomando el
        // numero.getValor() y pasarlo aplicarle el moduclo para pasar el valor a positivo
        try {
            if (numero < 0) {
                throw new IllegalArgumentException("El numero debe ser positivo. \n");
            }
            int invertido = InvertirNumero(numero);
            int multiplicado = MultiplicarPorSecuencia(invertido);
            int mod = CalcularModuloOnce(multiplicado);
            int Resultado = RestarAOnce(mod);

            System.out.println("Invertido: " + invertido);
            System.out.println("Multiplicado: " + multiplicado);
            System.out.println("Módulo 11: " + mod);
            System.out.println("Resultado final: " + Resultado);

            if (Resultado == 11) return 0;
            if (Resultado== 10) return 1;
            return Resultado;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
