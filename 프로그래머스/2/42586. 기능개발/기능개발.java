import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] calc = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int now = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) now++;
            calc[i] = now;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int count = 1;
        int idx = 0;
        for (int i = 1; i < progresses.length; i++) {
            if (calc[idx] >= calc[i]) {
                count++;
            } else {
                list.add(count);
                idx = i;
                count = 1;
            }
        }
       list.add(count);

        return list;
    }
}