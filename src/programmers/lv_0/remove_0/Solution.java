package programmers.lv_0.remove_0;

public class Solution {
    /* 0떼기 */
    public String solution(String n_str) {
        Integer s_num = Integer.parseInt(n_str);
        String answer = "";

        answer = s_num.toString();

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution("854020");
        System.out.println(answer);
    }
}
