package baekjoon.dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] maps;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();
        int[][] edges = new int[m][2];
        maps = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }

        for (int[] edge : edges) {
            maps[edge[0]][edge[1]] = 1;
            maps[edge[1]][edge[0]] = 1;
        }

        visited = new boolean[n + 1];
        dfs(start);

        visited = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next = 1; next < maps.length; next++) {
            if (maps[node][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        System.out.println();

        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next = 1; next < maps.length; next++) {
                if (maps[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
