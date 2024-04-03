package baekjoon.finding_the_parents_of_a_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        parent = new int[n + 1];
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

//        bfs(1);
        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : tree[cur]) {

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    parent[next] = cur;
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : tree[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
