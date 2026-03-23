import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        
        for (int i = 0 ; i < commands.length; i++) {
            int nowLength = commands[i][1] - commands[i][0] + 1;
            int[] nowArr = new int[nowLength];
            int idx = 0;
            
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                nowArr[idx++] = array[j];
            }
            
            Arrays.sort(nowArr);
            ans[i] = nowArr[commands[i][2]-1];
        }
            
        return ans;
    }
}