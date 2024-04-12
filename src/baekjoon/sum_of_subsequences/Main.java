package baekjoon.sum_of_subsequences;

import java.util.Scanner;

public class Main {

    static int N, S, count;
    static int[] numbers;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        S = scanner.nextInt();

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        recur(0, 0, 0);

        System.out.println(count);
    }

    private static void recur(int sum, int depth, int length) {

        if (depth == N) {
            if (length > 0 && sum == S) {
                count++;
            }
            return;
        }

        recur(sum + numbers[depth], depth + 1, length + 1);
        recur(sum, depth + 1, length);
    }
}
