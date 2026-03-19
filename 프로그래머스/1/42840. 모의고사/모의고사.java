import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] sum = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int nowAnswer = answers[i];
            if (p1[i%5] == nowAnswer) sum[0]++;
            if (p2[i%8] == nowAnswer) sum[1]++;
            if (p3[i%10] == nowAnswer) sum[2]++;
        }
        
        int max = Math.max(sum[0], Math.max(sum[1], sum[2]));
        
        for (int i = 0; i < 3; i++) {
           if (sum[i] == max) answer.add(i+1);
        }
        
        return answer;
    }
}