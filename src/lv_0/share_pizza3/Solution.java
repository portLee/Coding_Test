package lv_0.share_pizza3;

public class Solution {
    public int solution(int slice, int n) {
        return (n % slice == 0) ? n / slice : n / slice + 1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(4, 12);
        System.out.println("result = " + answer);
    }
}
