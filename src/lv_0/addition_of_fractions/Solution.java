package lv_0.addition_of_fractions;

public class Solution {
    /* 분수의 덧셈 */
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int numer3 = (numer1 * denom2) + (numer2 * denom1);
        int denom3 = denom1 * denom2;
        int gcd = gcd(numer3, denom3);

        answer[0] = numer3 / gcd;
        answer[1] = denom3 / gcd;

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
