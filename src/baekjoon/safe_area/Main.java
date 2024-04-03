package baekjoon.safe_area;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        maps = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = scanner.nextInt();
                maxHeight = Math.max(maxHeight, maps[i][j]);
            }
        }

        int max = 1;
        for (int h = 1; h < maxHeight; h++) {

            int count = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (maps[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
//                        bfs(i, j, h);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (maps[nx][ny] > height && !visited[nx][ny]) {
                    dfs(nx, ny, height);
                }
            }
        }
    }

    private static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (maps[nx][ny] > height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
