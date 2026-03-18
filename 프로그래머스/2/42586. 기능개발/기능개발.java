import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();

        int length = progresses.length;
        int current = -1;
        
        for (int i = 0 ; i < length ; i++) {
            int rest = 100 - progresses[i];
            int day = rest / speeds[i];
            
            if (rest % speeds[i] != 0) day++;
            
            if (day > current) {
                answer.offerLast(1);
                current = day;
            } else {
                answer.offerLast(answer.pollLast() + 1);
            }
        }
        return answer;
    }
}