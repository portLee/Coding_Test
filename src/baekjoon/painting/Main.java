package baekjoon.painting;

/*
* 1. 아이디어
* 2중 for => 값 1 && 방문X => BFS
* BFS 돌면서 그림 개수 +1, 최대값을 갱신
*
* 2. 시간복잡도
* BFS : O(V + E)
* V : N * M
* E : 4 V
* V + E = 5 V = 5 * N * M = 5 * 500 * 500 = 125만 < 2억 >> 가능
*
* 3. 자료구조
* 그래프 전체 지도 : int[][]
* 방문 : bool[][]
* Queue(BFS)
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m;
    static int[][] maps;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        maps = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                maps[i][j] = scanner.nextInt();
            }
        }

        int count = 0; // 전체 그림 개수
        int max = 0; // 최대 값
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    // maps 값이 1이면서 방문하지 않은 경우
                    visited[i][j] = true; // 방문으로 변경
                    count++; // 그림 개수 카운트
                    max = Math.max(max, bfs(i, j)); // 최대 값 갱신
                }
            }
        }

        System.out.println(count); // 그림 개수 출력
        System.out.println(max); // 최대 값 출력
    }

    static private int bfs(int x, int y) {
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ex = current[0];
            int ey = current[1];

            System.out.println("ex = " + ex + ", ey = " + ey);
            for (int k  = 0; k < 4; k++) {
                int nx = ex + dx[k];
                int ny = ey + dy[k];

                // 맵을 벗어나지 않는 조건
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        result++;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return result;
    }
}