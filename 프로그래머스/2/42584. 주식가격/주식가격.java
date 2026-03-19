import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int idx = 0; idx < prices.length; idx++) {
            while (!q.isEmpty() && prices[idx] < prices[q.peekLast()]) {
                int peek = q.peekLast();
                answer[q.pollLast()] = idx - peek;
            }
            q.offer(idx);
        }

        while (!q.isEmpty()) {
            int now = q.pollLast();
            answer[now] = prices.length - now -1;
        }
        return answer;
    }
}