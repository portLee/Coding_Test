package baekjoon.number_card2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        Arrays.sort(cards);

        for (int i = 0; i < m; i++) {
            int key = scanner.nextInt();

            System.out.print(upperBound(cards, key) - lowerBound(cards, key) + " ");
        }
    }

    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = (low + high) / 2;

            if (key <= arr[mid]) {
                high = mid;
            } else  {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (key < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
