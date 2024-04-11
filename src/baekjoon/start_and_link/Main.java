package baekjoon.start_and_link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] ability;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0 , 0);

        System.out.println(min);
    }

    private static void recur(int idx, int depth) {

        if (depth == n / 2) {
            calcAbilityDiff();
            return;
        }

        for (int k = idx; k < n; k++) {
            if (!visited[k]) {
                visited[k] = true;
                recur(k + 1, depth + 1);
                visited[k] = false;
            }
        }
    }

    private static void calcAbilityDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += ability[i][j];
                    startTeam += ability[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += ability[i][j];
                    linkTeam += ability[j][i];
                }
            }
        }

        // 스타트팀과 링크팀 절대값으로 비교
        int diff = Math.abs(startTeam - linkTeam);
        min = Math.min(min, diff);
    }
}
