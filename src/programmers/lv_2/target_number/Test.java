package programmers.lv_2.target_number;

class Solution {
    int[] numbers;
    int target;
    int answer;

    void dfs (int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 2. 수행동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }
}

public class Test {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Solution solution = new Solution();
        int answer = solution.solution(numbers, target);
        System.out.println(answer);
    }
}