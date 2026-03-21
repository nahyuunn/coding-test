import java.util.*;

class Solution {    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int current, int n, boolean[] visited, int[][] computers) {
        visited[current] = true;
        
        for (int next = 0; next < n; next++) {
            if (current != next && !visited[next] && computers[current][next] == 1) {
                dfs(next, n, visited, computers);
            }
        }
    }
}