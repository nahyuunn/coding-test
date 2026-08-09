import java.util.*;
import java.io.*;

public class Solution {

	static int maxLen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			List<Set<Integer>> list = new ArrayList<>();
			for (int n = 0; n < N+1; n++) {
				list.add(n, new HashSet<>());
			}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.get(x).add(y);
				list.get(y).add(x);
			}
			maxLen = 0;
			for (int i = 1; i <= N; i++) {
				dfs(i, 1, list, new boolean[N + 1]);
			}
			System.out.println("#" + t + " " + maxLen);
		}
	}
    
	private static void dfs(int cur, int len, List<Set<Integer>> list, boolean[] v) {
		v[cur] = true;
		
		for (int child : list.get(cur)) {
			if (!v[child]) {
				dfs(child, len+1, list, v);
				v[child] = false;
			}
		}
		maxLen = Math.max(maxLen, len);
	}

}