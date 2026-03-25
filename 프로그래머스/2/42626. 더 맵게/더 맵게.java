import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            answer++;
            pq.offer(pq.poll() + (pq.poll() * 2));
        }
        return answer;
    }
}