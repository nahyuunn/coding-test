import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numStrs = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = numbers[i] + "";
        }

        Arrays.sort(numStrs, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        if (numStrs[0].equals("0")) return "0";
        for (String s: numStrs) {
            answer += s;
        }
        return answer;
    }
}