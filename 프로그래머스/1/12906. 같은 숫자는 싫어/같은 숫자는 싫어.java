import java.util.*;

public class Solution {
    public int[] solution(int []arr) { 
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || num != stack.peek()) {
                stack.push(num);
            }
        }
        
        int size = stack.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = stack.pollLast();
        }
        
        return answer;
    }
}