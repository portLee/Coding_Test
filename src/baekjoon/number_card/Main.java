package baekjoon.number_card;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] cards, cards2;

    public static void main(String[] args) {
        int n, m;
        cards2 = new int[]{10, 9, -5, 2, 3, 4, 5, -10};

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        m = scanner.nextInt();
        cards2 = new int[m];

        for (int i = 0; i < m; i++) {
            cards2[i] = scanner.nextInt();
        }

        Arrays.sort(cards);

        for (int number : cards2) {
            System.out.print(binarySearch(number) + " ");
        }

    }

    private static int binarySearch(int number) {
        int low = 0;
        int high = cards.length - 1;

        while (high >= low) {
            int mid = (high + low) / 2;

            if (number > cards[mid]) {
                low = mid + 1;
            } else if (number < cards[mid]) {
                high = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
