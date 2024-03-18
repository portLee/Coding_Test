package lv_0.share_pizza2;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        answer = n / gcd(6, n);

        return answer;
    }

    private int gcd(int a, int b) {
        int temp = 0;

        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(4);
        System.out.println("result = " + answer);
    }
}
