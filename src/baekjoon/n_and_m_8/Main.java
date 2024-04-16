package baekjoon.n_and_m_8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] numbers, sequence;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        numbers = new int[n];
        sequence = new int[m];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        recur(0, 0);
    }

    private static void recur(int at, int depth) {

        if (depth == m) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();

            return;
        }

        for (int i = at; i < n; i++) {
            sequence[depth] = numbers[i];
            recur(i, depth + 1);
        }
    }
}
