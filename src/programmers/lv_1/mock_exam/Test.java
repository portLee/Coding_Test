package programmers.lv_1.mock_exam;

import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        // 수포자들이 맞춘 문제 수 카운트
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % answer1.length]) {
                scores[0]++;
            }
            if (answers[i] == answer2[i % answer2.length]) {
                scores[1]++;
            }
            if (answers[i] == answer3[i % answer3.length]) {
                scores[2]++;
            }

        }

        int[] sortScores = scores.clone(); // 점수 복사
        Arrays.sort(sortScores);
        int max = sortScores[2];
        ArrayList<Integer> maxScore = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                maxScore.add(i + 1);
            }
        }

        answer = new int[maxScore.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = maxScore.get(i);
        }



        return answer;
    }
}

public class Test {
}
