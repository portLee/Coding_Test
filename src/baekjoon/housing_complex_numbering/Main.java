package baekjoon.housing_complex_numbering;

import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] maps;
    static boolean[][] visited;
    static ArrayList<Integer> counts;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        maps = new int[n][n];
        visited = new boolean[n][n];
        counts = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] strArr = scanner.next().split("");
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    counts.add(bfs(i, j));
                }
            }
        }

        Collections.sort(counts);
        System.out.println(counts.size());
        counts.forEach(System.out::println);
    }

    private static int bfs(int x, int y) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];
            result++;

            for (int k = 0; k < 4; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return result;
    }
}
