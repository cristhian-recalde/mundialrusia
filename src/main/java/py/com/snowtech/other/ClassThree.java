package py.com.snowtech.other;

public class ClassThree {

    public void processor(Integer[] repetidas, Integer[] faltantes) {
        int indexRepetidas = 0, lengthRepetidas = repetidas.length;
        int indexFaltantes = 0, lengthFaltantes = faltantes.length;
        int common = 0;
        System.out.println(
                "---- total repetidas = [" + lengthRepetidas + "], total faltantes = [" + lengthFaltantes + "]");

        while (indexFaltantes < lengthFaltantes && indexRepetidas < lengthRepetidas) {
            // System.out.println("***** repetidas: [" + repetidas[indexRepetidas] + "], faltante [" + faltantes[indexFaltantes] + "], indexRepetidas: [" + indexRepetidas + "], indexFaltantes: [" + indexFaltantes + "]");
            if (repetidas[indexRepetidas].equals(faltantes[indexFaltantes])) {
                System.out.print(faltantes[indexFaltantes] + " ");
                indexFaltantes++;
                indexRepetidas++;
                ++common;
            } else if (repetidas[indexRepetidas] < faltantes[indexFaltantes]) {
                indexRepetidas++;
            } else {
                indexFaltantes++;
            }
        }
        System.out.println("\nTotal in common = " + common);
    }
}
