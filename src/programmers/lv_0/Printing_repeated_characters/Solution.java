package programmers.lv_0.Printing_repeated_characters;

public class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            String cStr = Character.toString(my_string.charAt(i));
            answer.append(cStr.repeat(n));
        }

        return answer.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer =  solution.solution("hello", 3);
        System.out.println("result = " + answer);
    }
}