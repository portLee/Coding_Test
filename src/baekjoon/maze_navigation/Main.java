package baekjoon.maze_navigation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] maps, visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        maps = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] strArr = scanner.next().split("");
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(strArr[j]);

                if (maps[i][j] == 0) {
                    visited[i][j] = 1;
                }
            }
        }

        bfs(0, 0);

        System.out.println(visited[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[ex][ey] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
