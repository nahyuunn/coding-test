import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n+1];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    
    
    void bfs(int n, boolean[] visited, int[][] computers) {
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int i = 0; i < computers.length; i++) {
                if (cur == i || visited[i] || computers[cur][i] == 0) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}