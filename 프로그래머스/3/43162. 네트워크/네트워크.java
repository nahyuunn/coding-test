import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        visited = new boolean[n];
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, visited, list);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int current, int n, boolean[] visited, List<List<Integer>> list) {
        visited[current] = true;
        
        if (list.get(current).isEmpty()) {
            return;
        }
        
        for (int next: list.get(current)) {
            if (!visited[next]) {
                dfs(next, n, visited, list);
            }
        }
    }
}