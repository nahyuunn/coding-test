import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int num : arr) {
            if (stack.isEmpty()) {
                stack.offerLast(num);
                continue;
            }
            if (num == stack.peekLast()) {
                stack.pollLast();
            }
            stack.offerLast(num);
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pollFirst();
        }

        return answer;
    }
}