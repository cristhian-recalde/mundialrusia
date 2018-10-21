package test;

import java.util.ArrayList;
import java.util.List;

public class ProgramTest {
    private static final int MAX = 100;

    public static void main(String[] args) {
        print(missingNumbers(new Integer[] {50, 40, 30, 20, 99, 100}));
        System.out.println(compare(0.4f, 0.1f));
        System.out.println(compare(0.5f, 0.3f));
        System.out.println(compare(0.1f, 0.2f));
        System.out.println(compare(0.1f, 0.10f));
    }

    // # 1
    public static boolean compare(float a, float b) {
        if (a < b || b < a) {
            return false;
        }
        return Float.floatToIntBits(a) == Float.floatToIntBits(b);
    }

    private int latb() {
        return 0;
    }

    // #2

    /**
     * #2 -
     *
     */

    // #3 : Complexity = O(n)
    public static Integer[] missingNumbers(Integer[] numbers) {
        boolean [] existing = new boolean[MAX + 1];

        // O(n)
        for (int index = 0; index < numbers.length; index++) {
            existing[numbers[index]] = true; // O(1)
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            if (!existing[i]) { //O(1)
                missing.add(i); //O(n)
            }
        }

        // O(n)
        return missing.stream().toArray(Integer[]::new);
    }

    private static void print(Integer[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }
}
