import java.io.*;
import java.util.*;

public class Solution {
	static int[][] b;
	static int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
 
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			b = new int[N][N];
			init(N);
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				int stone = Integer.parseInt(st.nextToken());
				b[r][c] = stone;
				go(r, c, stone, N);
			}
			
			int black = 0;
			int white = 0;
			for (int[] s : b) {
				for (int now : s) {
					if (now == 1) black++;
					else if (now == 2) white++;
				}
			}
			
			System.out.println("#" + t + " " + black + " " + white);
		}

	}
	
	private static void init(int N) {
		b[N/2-1][N/2-1] = 2;
		b[N/2-1][N/2] = 1;
		b[N/2][N/2-1] = 1;
		b[N/2][N/2] = 2;
	}
	
	private static void go(int r, int c, int stone, int N) {
		for (int i = 0; i < d.length; i++) {
			int nR = r + d[i][0];
			int nC = c + d[i][1];
			
			if (nR >= 0 && nR < N && nC >= 0 && nC < N) {
				if (b[nR][nC] != 0 && b[nR][nC] != stone) {
					boolean find = false;
					int count = 1;
					
					while (true) {
						nR += d[i][0];
						nC += d[i][1];
						if (nR >= 0 && nR < N && nC >= 0 && nC < N && b[nR][nC] != 0) {
							if (b[nR][nC] == stone) {
								find = true;
								break;
							} else if (b[nR][nC] != 0) count++;
						} else break;
					}
					
					if (find) {
						while (count-- > 0) {
							nR -= d[i][0];
							nC -= d[i][1];
							b[nR][nC] = stone;
						}
					}
				}
			}
		}
	}
}