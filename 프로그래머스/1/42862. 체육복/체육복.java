import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Queue<Integer> lostSet = new PriorityQueue<>();
        Queue<Integer> reserveSet = new PriorityQueue<>();

        for (int s : lost) {
            lostSet.offer(s);
        }
        
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
                reserveSet.remove(r);
            }
            else reserveSet.offer(r);
        }
        
        int count = 0;
        
        while (!lostSet.isEmpty()) {
            int cur = lostSet.poll();

            if (reserveSet.contains(cur - 1)) {
                reserveSet.remove(cur - 1);
                continue;
            }
            if (reserveSet.contains(cur + 1)) {
                reserveSet.remove(cur + 1);
                continue;
            }
            else count++;
        }
        
        answer = n - count;
        return answer;
    }
}