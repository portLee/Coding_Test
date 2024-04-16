package baekjoon.create_a_password;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L, C;
    static String[] alpha;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();

        alpha = new String[C];
        for (int i = 0; i < C; i++) {
            alpha[i] = scanner.next();
        }

        Arrays.sort(alpha);

        recur(0, 0, "");
    }

    private static void recur(int at, int depth, String password) {

        if (depth == L) {
            if (isValid(password)) {
                System.out.println(password);
            }
            return;
        }


        for (int i = at; i < C; i++) {
            recur(i + 1, depth + 1, password + alpha[i]);
        }
    }

    private static boolean isValid(String password) {
        int vowels = 0;
        int consonants = 0;

        for (char c : password.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) { // 모음인 경우
                vowels++;
            } else { // 자음인 경우
                consonants++;
            }
        }

        return vowels >= 1 && consonants >= 2;
    }
}