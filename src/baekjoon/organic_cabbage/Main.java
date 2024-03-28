package baekjoon.organic_cabbage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int t, n, m, k;
    static int[] counts;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        counts = new int[t];
        for (int idx = 0; idx < t; idx++) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            k = scanner.nextInt();

            int [][] edges = new int[k][2];
            maps = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 2; j++) {
                    edges[i][j] = scanner.nextInt();
                }
            }

            for (int[] edge : edges) {
                maps[edge[1]][edge[0]] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (maps[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        counts[idx]++;
                    }
                }
            }
        }

        for (int count : counts) {
            System.out.print(count + " ");
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

            for (int l = 0; l < 4; l++) {
                int nx = ex + dx[l];
                int ny = ey + dy[l];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
