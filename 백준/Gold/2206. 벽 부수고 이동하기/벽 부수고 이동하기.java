import java.util.*;
import java.io.*;

public class Main {

    static int[][] direction = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[N][M][2];

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j];
            }
        }

        System.out.println(bfs(map, visited, N, M));
    }
    static int bfs(char[][] map, boolean[][][] visited, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0,0,1});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int brk = cur[2];

            if (cur[0] == n-1 && cur[1] == m-1) return cur[3];

            for (int i = 0; i < 4; i++) {
                int nxtN = cur[0] + direction[i][0];
                int nxtM = cur[1] + direction[i][1];

                if (nxtN >= 0 && nxtN < n && nxtM >= 0 && nxtM < m){
                    if (map[nxtN][nxtM] == '1') {
                        if (brk == 0) {
                            if (!visited[nxtN][nxtM][1]) {
                                q.offer(new int[]{nxtN, nxtM, 1, cur[3] + 1});
                                visited[nxtN][nxtM][1] = true;
                            }
                        }
                    }
                    else {
                        if (!visited[nxtN][nxtM][brk]) {
                            q.offer(new int[]{nxtN, nxtM, brk, cur[3] + 1});
                            visited[nxtN][nxtM][brk] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}