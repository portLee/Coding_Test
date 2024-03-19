package programmers.lv_0.double_the_array;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int[] answer = solution.solution(numbers);
        System.out.println(Arrays.toString(answer));
    }
}