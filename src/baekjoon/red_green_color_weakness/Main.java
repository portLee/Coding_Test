package baekjoon.red_green_color_weakness;

import java.util.*;

public class Main {

    static int n;
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        maps = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            maps[i] = scanner.next().split("");
        }

        // 정상인 경우
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
//                    bfs(i, j);
                    count++;
                }
            }
        }
        int normal = count;
        count = 0;
        visited = new boolean[n][n];

        // 비정상인 경우
        // G를 R로 변경 후 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j].equals("G")) {
                    maps[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
//                    bfs(i, j);
                    count++;
                }
            }
        }
        int abnormal = count;

        System.out.println(normal + " " + abnormal);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (maps[nx][ny].equals(maps[x][y]) && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        String tmpStr = maps[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (maps[nx][ny].equals(tmpStr) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
