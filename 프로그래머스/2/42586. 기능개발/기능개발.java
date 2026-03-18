import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
            
        int length = progresses.length;
        
        for (int i = 0 ; i < length ; i++) {
            int rest = 100 - progresses[i];
            int day = rest / speeds[i];

            if (rest % speeds[i] != 0) {
                day++;
            }
            
            if (q.isEmpty() || day > q.peekLast()) {
                answer.offerLast(1);
                q.offerLast(day);
            } else {
                int cur = answer.pollLast() + 1;
                answer.offerLast(cur);
            }
        }
        return answer;
    }
}