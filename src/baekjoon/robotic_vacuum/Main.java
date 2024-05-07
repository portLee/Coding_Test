package baekjoon.robotic_vacuum;

import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m, x, y, d; // d = 0은 북쪽, 1은 동쪽, 2는 남쪽, 3은 서쪽
    static int[][] maps;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        y = scanner.nextInt();
        x = scanner.nextInt();
        d = scanner.nextInt();

        maps = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                maps[j][i] = scanner.nextInt();
            }
        }

        int count = 0;
        boolean isBrank = false;

        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (maps[y][x] == 0) {
                maps[y][x] = 2;
                count++;
            }
            isBrank = false;

            for (int k = 1; k <= 4; k++) {
                int nd = (d - k + 4) % 4;
                int ny = y + dy[nd];
                int nx = x + dx[nd];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (maps[ny][nx] == 0) {
                        d = nd;
                        y = ny;
                        x = nx;
                        isBrank = true;
                        break;
                    }
                }
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!isBrank) {
                int ny = y - dy[d];
                int nx = x - dx[d];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (maps[ny][nx] != 1) {
                        y = ny;
                        x = nx;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
