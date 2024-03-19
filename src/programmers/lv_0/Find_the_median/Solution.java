package programmers.lv_0.Find_the_median;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int index = array.length / 2;

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        answer = array[index];

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        int[] array = {9, -1, 0};
        Solution solution = new Solution();
        int answer = solution.solution(array);
        System.out.println(answer);
    }
}
