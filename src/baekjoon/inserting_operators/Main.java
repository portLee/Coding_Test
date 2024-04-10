package baekjoon.inserting_operators;

import java.util.Scanner;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] numbers, operators;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numbers = new int[n];
        operators = new int[4]; // [0] = '+', [1] = '-', [2] = '*', [3] = '/'

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int j = 0; j < 4; j++) {
            operators[j] = scanner.nextInt();
        }

        recur(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recur(int num, int idx) {

        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for (int k = 0; k < 4; k++) {

            if (operators[k] > 0) {

                // 해당 연산자를 1감소
                operators[k]--;

                switch (k) {
                    case 0 -> recur(num + numbers[idx], idx + 1);
                    case 1 -> recur(num - numbers[idx], idx + 1);
                    case 2 -> recur(num * numbers[idx], idx + 1);
                    case 3 -> recur(num / numbers[idx], idx + 1);
                }
                
                // 재귀호출 종료 후 해당 연산자 개수 복구
                operators[k]++;
            }
        }
    }
}
