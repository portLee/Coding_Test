package baekjoon.number_of_connection_elements;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] maps;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }

        maps = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int[] edge : edges) {
            maps[edge[0]][edge[1]] = 1;
            maps[edge[1]][edge[0]] = 1;
        }

        int count = 0;

        for (int k = 1; k < n + 1; k++) {
            if (!visited[k]) {
                dfs(k);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next = 1; next < n + 1; next++) {
            if (maps[node][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}
