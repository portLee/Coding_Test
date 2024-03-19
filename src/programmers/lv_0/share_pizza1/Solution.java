package programmers.lv_0.share_pizza1;

public class Solution {
    public int solution(int n) {
        return (n % 7 == 0) ? n / 7 : n / 7 + 1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(3);
        System.out.println("result = " + answer);
    }
}
