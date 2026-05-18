import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] store = new int [11112];
			for (int i = M; i < 11111; i+=M) {
				store[i] = K;
			}
			
			int[] visitors = new int[N];
			int last = 0;
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				int cur = Integer.parseInt(st.nextToken());
				store[cur]--;
				visitors[n] = cur;
				last = Math.max(last, cur);
			}
			
			for (int i = 1; i <= last; i++) {
				store[i] = store[i - 1] + store[i];
			}
			
			boolean isP = true;
			for (int v: visitors) {
				if (store[v] < 0) {
					isP = false;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(isP ? "Possible" : "Impossible");
			if (t != T) sb.append("\n");
		}
		System.out.print(sb);
	}
}