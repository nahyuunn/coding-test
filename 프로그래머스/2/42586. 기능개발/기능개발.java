import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int pl = progresses.length;
        int[] workDays = new int[pl];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < pl; i++) {
            int n = 100 - progresses[i];
            workDays[i] = n % speeds[i] == 0 ? n / speeds[i] : n / speeds[i] + 1;
        }
        
        for (int i = 0; i < pl; i++) {
            int count = 1;

            for (int j = i+1; j <= pl; j++) {
                if (j == pl || workDays[i] < workDays[j]) {
                    ans.add(count);
                    i = j-1;
                    break;
                }
                else count++;
            }
        }
        int[] answer = new int[ans.size()];
        int idx = 0;
        for (int a : ans) {
            answer[idx++] = a;
        }
        return answer;
    }
}