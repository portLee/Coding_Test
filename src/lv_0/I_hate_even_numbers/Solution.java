package lv_0.I_hate_even_numbers;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n + 1) / 2];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(15);
        System.out.println(Arrays.toString(answer));
    }
}