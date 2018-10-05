package py.com.snowtech;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer [] repetidas = loadFromFile("repetidas.txt", "-");
        Integer [] faltantes = loadFromFile("faltantes.txt", "-");
        workItOut(repetidas, faltantes);
    }

    private static void workItOut(Integer[] repetidas, Integer[] faltantes) {
        int indexRepetidas = 0, lengthRepetidas = repetidas.length;
        int indexFaltantes = 0, lengthFaltantes = faltantes.length;
        int common = 0;
        System.out.println("---- total repetidas = [" + lengthRepetidas + "], total faltantes = [" + lengthFaltantes + "]");

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

    private static Integer[] loadFromFile(String s, String separator) throws IOException {
        String[] fileString = FileUtils.readFileToString(new File(s)).replaceAll("\\R", separator).split(separator);
        Set<Integer> numbers = new TreeSet<>();

        for (String str : fileString) {
            numbers.add(Integer.parseInt(str));
        }

        return numbers.stream().toArray(Integer[]::new);
    }

}
