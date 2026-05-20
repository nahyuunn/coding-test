import java.util.*;
import java.io.*;

public class Solution {

	static int min = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] h = new int[N];
			st = new StringTokenizer(br.readLine());
			
			min = 0;

			for (int n = 0; n < N; n++) {
				h[n] = Integer.parseInt(st.nextToken());
				min += h[n];
			}
			dfs(0, 0, h, B);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	private static void dfs(int sum, int i, int[] h, int B) {
		if (sum >= B) {
			min = Math.min(min, sum - B);
		}
		
		if (i == h.length) return;
		
		if (i + 1 <= h.length) {
			dfs(sum + h[i], i + 1, h, B);
			dfs(sum, i + 1, h, B);
		}
	}
}