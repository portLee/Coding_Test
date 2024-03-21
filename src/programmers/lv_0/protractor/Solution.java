package programmers.lv_0.protractor;

public class Solution {
    public int solution(int angle) {
        int answer = 0;

        if (angle == 180) {
            answer = 4;
        } else if (angle < 180 && angle > 90) {
            answer = 3;
        } else if (angle == 90) {
            answer = 2;
        } else if (angle < 90) {
            answer = 1;
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(70);
        System.out.println("result = " + answer);
    }
}
