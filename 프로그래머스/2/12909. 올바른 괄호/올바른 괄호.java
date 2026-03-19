import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Integer> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                q.offer(1);
            } else if (q.isEmpty()) {
                return false;
            } else {
                q.poll();
            }
        }
        return (!q.isEmpty()) ? false : true;
    }
}