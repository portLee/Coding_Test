package baekjoon.Find_number;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] arr2;

    public static void main(String[] args) {
        int n, m;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        m = scanner.nextInt();
        arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // 배열 정렬

        for (int num : arr2) {
            System.out.println(binarySearch(num));
        }
    }

    private static int binarySearch(int goal) {
        int low = 0;
        int high = arr.length - 1;

        while (high >= low) {

            int mid = (low + high) / 2;

            if (goal > arr[mid]) {
                low = mid + 1;
            } else if (goal < arr[mid]) {
                high = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
