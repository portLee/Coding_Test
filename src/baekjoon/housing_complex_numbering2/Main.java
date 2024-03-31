package baekjoon.housing_complex_numbering2;

import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, count;
    static int[][] maps;
    static boolean[][] visited;
    static ArrayList<Integer> result;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        maps = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] strArr = scanner.next().split("");
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        count++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
