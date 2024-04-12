package baekjoon.n_queen;

import java.util.Scanner;

public class Main {

    static int n, count;
    static int[] board;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n];

        recur(0);

        System.out.println(count);
    }

    private static void recur(int depth) {

        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if (possibility(depth)) {
                recur(depth + 1);
            }
        }
    }

    private static boolean possibility(int depth) {
        for (int i = 0; i < depth; i++) {

            if (board[depth] == board[i]) { // 직선 확인
                return false;
            }

            if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) { // 대각선 확인
                return false;
            }
        }

        return true;
    }
}
