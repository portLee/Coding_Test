package programmers.lv_0.Find_the_mode;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int mode = 0;
        int modeCnt = 0;


        for (int num : array) {
            int count = 0;
            for (int num2 : array) {
                if (num == num2) {
                    count++;
                }
            }
            if (count > modeCnt) {
                mode = num;
                modeCnt = count;
                answer = mode;
            } else if (count == modeCnt && mode != num) {
                answer = -1;
            }
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2};
        Solution solution = new Solution();
        int answer = solution.solution(array);
        System.out.println(answer);
    }
}
