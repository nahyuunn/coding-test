import java.util.*;

class Solution {
    
    int[][] direction = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        boolean[][] visited = new boolean[N][M];
        
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int n = cur[0];
            int m = cur[1];
            int w = cur[2];
            
            if (n == N - 1 && m == M - 1) {
                answer = w;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int stepN = direction[i][0];
                int stepM = direction[i][1];
                
                int nxtN = n + stepN;
                int nxtM = m + stepM;
                
                if (nxtN >= 0 && nxtN < N && nxtM >= 0 && nxtM < M) {
                    if (!visited[nxtN][nxtM]) {
                        if (maps[nxtN][nxtM] == 1) {
                            q.offer(new int[] {nxtN, nxtM, w+1});
                            visited[nxtN][nxtM] = true;
                        }
                    }
                }
            }
            answer = -1;
        }
        return answer;
    }
}