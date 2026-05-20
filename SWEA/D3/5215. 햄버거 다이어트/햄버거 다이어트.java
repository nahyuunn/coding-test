import java.io.*;
import java.util.*;

public class Solution {
	static int scr = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] igd = new int [N][2];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				igd[n][0] = Integer.parseInt(st.nextToken());
				igd[n][1] = Integer.parseInt(st.nextToken());
			}
			
			scr = 0;
			dfs(0, 0, 0, igd, K);
			
			System.out.println("#" + t + " " + scr);
		}
	}
	
	private static void dfs(int score, int sum, int i, int[][] igd, int K) {	
		if (sum <= K) {
			scr = Math.max(scr, score);
		}
		
		if (i == igd.length) {
			return;
		}
		
		if (sum + igd[i][1] <= K) {
			dfs(score + igd[i][0], sum + igd[i][1], i+1, igd, K);
		}
		dfs(score, sum, i+1, igd, K);
	}
}