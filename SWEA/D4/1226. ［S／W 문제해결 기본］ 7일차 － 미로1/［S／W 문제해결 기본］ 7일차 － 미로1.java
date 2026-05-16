import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] d = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			char[][] miro = new char[16][16];
						
			for (int i = 0; i < 16; i++) {
				miro[i] = br.readLine().toCharArray();
			}
			
			int ans = bfs(new boolean[16][16], miro) ? 1 : 0;
			sb.append("#").append(tc).append(" ").append(ans);
			if (t != 10) sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean bfs(boolean[][] visited, char[][] miro) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[1][1] = true;
		q.offer(new int[]{1,1});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();			
			if (miro[now[0]][now[1]] == '3') return true;

			for (int i = 0; i < 4; i++) {
				int nxtX = now[0] + d[i][0];
				int nxtY = now[1] + d[i][1];
				if (nxtX >= 0 && nxtX < 16 && nxtY >= 0 && nxtY < 16) {
					if (miro[nxtX][nxtY] != '1' && !visited[nxtX][nxtY]) {
						q.offer(new int[] {nxtX, nxtY});
						visited[nxtX][nxtY] = true;
					}	
				}
			}
		}
		
		return false;
	}
}