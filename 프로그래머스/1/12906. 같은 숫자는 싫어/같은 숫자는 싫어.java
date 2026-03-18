import java.util.*;

public class Solution {
    public int[] solution(int []arr) { 
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || num != stack.peek()) {
                stack.push(num);
            }
        }
        
        int i = 0;
        int[] answer = new int[stack.size()];
        while (!stack.isEmpty()) {
            answer[i++] = stack.pollLast();
        }
        return answer;
    }
}