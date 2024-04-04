package baekjoon.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int w, h;
    static int[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();

            if (w + h == 0) {
                break;
            }

            maps = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    maps[i][j] = scanner.nextInt();
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (maps[i][j] == 1 && !visited[i][j]) {
//                        dfs(i, j);
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];

            for (int k = 0; k < 8; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
