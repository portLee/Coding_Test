package baekjoon.virus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 컴퓨터 대수(vertex)
        m = scanner.nextInt(); // 간선 수(Edge)

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < 2; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }

        matrix = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int node) {
        boolean[] visited = new boolean[n + 1];
        visited[node] = true;
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int k = 1; k <= n; k++) {

                if (matrix[curNode][k] == 1 && !visited[k]) {
                    visited[k] = true;
                    count++;
                    queue.offer(k);
                }
            }
        }

        return count;
    }
}
