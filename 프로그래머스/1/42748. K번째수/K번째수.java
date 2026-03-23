import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0 ; i < commands.length; i++) {
            int nowLength = commands[i][1] - commands[i][0] + 1;
            int[] nowArr = new int[nowLength];
            int idx = 0;
            
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                nowArr[idx++] = array[j];
            }
            
            Arrays.sort(nowArr);
            ans.add(nowArr[commands[i][2]-1]);
        }
            
        return ans;
    }
}