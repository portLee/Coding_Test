package baekjoon.n_and_m_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, m;
    static ArrayList<Integer> result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        result = new ArrayList<>();
        visited = new boolean[n + 1];

        recur(0);
    }

    private static void recur(int num) {

        if (num == m) {
            result.forEach(value -> System.out.print(value + " "));
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);
                recur(num + 1);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
