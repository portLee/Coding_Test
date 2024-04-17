package baekjoon.chicken_delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] combiArr;
    static List<int[]> house, chicken;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        combiArr = new int[M];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = scanner.nextInt();

                if (temp == 1) { // 1이면 집
                    house.add(new int[]{i, j});
                } else if (temp == 2) { // 2면 치킨집
                    chicken.add(new int[]{i, j});
                }
            }
        }

        recur(0, 0);

        System.out.println(MIN);
    }

    private static void recur(int index, int depth) {

        if (depth == M) {

            int totalDist = 0;

            for (int[] h : house) {

                int minDist = Integer.MAX_VALUE;

                for (int idx : combiArr) {
                    int[] c = chicken.get(idx);
                    minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }

                totalDist += minDist;
            }

            MIN = Math.min(MIN, totalDist);

            return;
        }

        for (int k = index; k < chicken.size(); k++) {
            combiArr[depth] = k;
            recur(k + 1, depth + 1);
        }
    }
}
