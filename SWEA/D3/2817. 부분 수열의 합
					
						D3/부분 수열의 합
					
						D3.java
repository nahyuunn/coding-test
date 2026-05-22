import java.io.*;
import java.util.*;

public class Solution {
	static int count = 0;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			nums = new int[N];
			count = 0;
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				nums[n] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, K);
			System.out.println("#" + t + " " + count);
		}
	}
	
	private static void dfs(int n, int sum, int K) {
		if (sum == K) {
			count++;
			return;
		}
		
		if (n == nums.length) {
			return;
		}

		dfs(n + 1, sum + nums[n], K);
		dfs(n + 1, sum, K);
	}
}