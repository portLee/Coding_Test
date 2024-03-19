package programmers.lv_1.fruiterer;

import java.util.*;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] temp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());

        for (int i = m - 1; i < temp.length; i += m) {
            answer += temp[i] * m;
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        Solution solution = new Solution();
        int answer = solution.solution(4, 3, score);
        System.out.println("result = " + answer);
    }
}