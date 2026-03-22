import java.util.*;

class Solution {
    static int[][] paths = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps.length-1, maps[0].length-1, visited, maps);
    }
    
    public int bfs(int n, int m, boolean[][] visited, int[][] maps) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        count++;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n && cur[1] == m) {
                return cur[2];
            }
            for(int[] path: paths) {
                int nx = cur[0]+path[0];
                int ny = cur[1]+path[1];
                int nd = cur[2] + 1;
                if (nx >= 0 && ny >= 0 && nx <= n && ny <= m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny, nd});
                        visited[nx][ny] = true;
                        count++;
                    }   
                }
            }
        }
        return -1;
    }
}