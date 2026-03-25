import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new TreeSet<>();
        for (int l : lost) {
            lostSet.add(l);
        }
        
        Set<Integer> reserveSet = new TreeSet<>();
        for (int r: reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
            }
            else {
                reserveSet.add(r);
            }
        }
        
        int count = 0;
        
        for (int cur: lostSet) {
            if (reserveSet.contains(cur - 1)) {
                count++;
                reserveSet.remove(cur - 1);
                continue;
            }
            if (reserveSet.contains(cur + 1)) {
                count++;
                reserveSet.remove(cur + 1);
                continue;
            }
        }
        
        answer = n - (lostSet.size()-count);
        return answer;
    }
}