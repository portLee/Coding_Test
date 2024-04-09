package baekjoon.n_and_m_3;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];

        recur(0);
        bw.flush();
        bw.close();
    }

    private static void recur(int depth) throws IOException {

        if (depth == m) {
            for (int value : result) {
                bw.write(value + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            recur(depth + 1);
        }
    }
}