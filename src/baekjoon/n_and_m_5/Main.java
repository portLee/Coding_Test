package baekjoon.n_and_m_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static int n, m;
    static int[] arr, result;
    static boolean[] visited;
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // 오름차순 정렬

        recur(0);
    }

    private static void recur(int depth) {

        if (depth == m) {
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                recur(depth + 1);
                visited[i] = false;
            }
        }
    }
}
