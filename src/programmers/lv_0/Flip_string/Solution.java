package programmers.lv_0.Flip_string;

public class Solution {
    public String solution(String my_string) {
        String answer = "";

        for (int i = my_string.length() - 1; i >= 0; i--) {
            answer += my_string.charAt(i);
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        String my_string = "jaron";
        Solution solution = new Solution();
        String answer = solution.solution(my_string);
        System.out.println("result = " + answer);
    }
}
