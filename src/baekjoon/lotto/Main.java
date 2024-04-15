package baekjoon.lotto;

import java.util.Scanner;

public class Main {

    static int k;
    static int[] numbers, lotto;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            k = scanner.nextInt();
            
            if (k == 0) { // k이가 0일 경우 반복문 종료
                break;
            }
            
            numbers = new int[k];
            lotto = new int[6];

            for (int i = 0; i < k; i++) {
                numbers[i] = scanner.nextInt();
            }

            recur(0, 0);
            System.out.println();
        }
    }

    private static void recur(int at, int depth) {
        if (depth == 6) {
            for (int num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();

            return;
        }

        for (int i = at; i < k; i++) {
            lotto[depth] = numbers[i];
            recur(i + 1, depth + 1);
        }
    }
}
