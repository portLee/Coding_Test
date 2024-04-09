package baekjoon.n_and_m_4;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        result = new int[m];

        recur(1, 0);
    }

    private static void recur(int at, int depth) {

        if (depth == m) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            result[depth] = i;
            recur(i, depth + 1);
        }
    }
}
