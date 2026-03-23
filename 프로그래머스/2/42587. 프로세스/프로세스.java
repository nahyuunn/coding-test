import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {       
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            q.offerLast(new int[]{i, priorities[i]});
        }
        
        int count = 1;
        int max = pq.poll();
        
        while (!q.isEmpty()) {
            if (q.peekFirst()[1] < max) {
                q.offerLast(q.pollFirst());
            }
            else {
                if (q.peekFirst()[0] == location) return count;
                q.pollFirst();
                max = pq.poll();
                count++;
            }
        }
        return count;
    }
    
}