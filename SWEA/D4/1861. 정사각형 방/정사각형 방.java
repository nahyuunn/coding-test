import java.util.*;
import java.io.*;

public class Solution {
	
	static int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] rooms = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = go(i, j, rooms, new boolean[N][N]);
					
					if (count == max) {
						ans = Math.min(ans, rooms[i][j]);
					} else if (count > max) {
						max = count;
						ans = rooms[i][j];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append(" ").append(max);
			if (t != T) sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int go(int i, int j,int[][] rooms, boolean[][] visited) {
		
		int count = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{i, j});
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowI = now[0];
			int nowJ = now[1];
			count++;
			
			for (int d = 0; d < 4; d++) {
				int x = direction[d][0];
				int y = direction[d][1];

				int nxtI = nowI + x;
				int nxtJ = nowJ + y;
				if (nxtI >= 0 && nxtI < rooms.length && nxtJ >= 0 && nxtJ < rooms.length) {
					if (Math.abs(rooms[nowI][nowJ] - rooms[nxtI][nxtJ]) == 1) {
						if (!visited[nxtI][nxtJ]) {
							q.offer(new int[] {nxtI, nxtJ});
							visited[nxtI][nxtJ] = true;
						}
					}
				}
			}
		}
		return count;
	}
}