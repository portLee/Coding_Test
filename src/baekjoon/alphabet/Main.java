package baekjoon.alphabet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int r, c, max;
    static String[][] maps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();

        maps = new String[r][c];

        for (int i = 0; i < r; i++) {
            maps[i] = scanner.next().split("");
        }

        dfs(0, 0, maps[0][0]);
//        bfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int x, int y, String str) {
        // 방문한 문자열의 길이를 확인하여 최대값 갱신
        max = Math.max(max, str.length());
        System.out.println("curStr = " + str);

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!str.contains(maps[nx][ny])) {
                    dfs(nx, ny, str + maps[nx][ny]);
                }
            }
        }
    }

    // bfs는 고민해봐야 할듯..
//    private static void bfs(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{x, y});
//        String[][] visited = new String[r][c];
//        visited[x][y] = maps[x][y];
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int ex = current[0];
//            int ey = current[1];
//
//            for (int k = 0; k < 4; k++) {
//                int nx = ex + dx[k];
//                int ny = ey + dy[k];
//
//                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
//                    if (!visited[ex][ey].contains(maps[nx][ny])) {
//                        visited[nx][ny] = visited[ex][ey] + maps[nx][ny];
//                        queue.offer(new int[]{nx, ny});
//                    }
//                }
//            }
//
//            System.out.println("ex = " + ex + ", ey = " + ey + ", " + visited[ex][ey]);
//            max = Math.max(max, visited[ex][ey].length());
//        }
//
//        for (String[] arr : visited) {
//            System.out.println(Arrays.toString(arr));
//        }
//    }
}
