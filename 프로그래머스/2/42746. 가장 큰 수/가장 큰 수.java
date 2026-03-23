import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int length = numbers.length;
        String[] convertedNums = new String[length];
        
        int idx = 0;
        for (int n : numbers) {
            convertedNums[idx++] = n + "";
        }
        
        Arrays.sort(convertedNums, (a, b) -> (a + b).compareTo(b + a));
        
        if (convertedNums[length - 1].equals("0")) return "0";
        
        for (int i = 0; i < length; i++) {
            answer += convertedNums[length - i - 1];
        }
        
        return answer;
    }
}