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
			int Q = Integer.parseInt(st.nextToken());

			int[] box = new int[N];
			for (int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());

				int L = Integer.parseInt(st.nextToken()) - 1;
				int R = Integer.parseInt(st.nextToken()) - 1;
				
				for (int j = L; j <= R; j++) {
					box[j] = i;
				}
			}
			sb.append("#").append(t).append(" ");
			for (int n: box) {
				sb.append(n).append(" ");
			}
			if (t != T) sb.append("\n");
		}
		System.out.println(sb);
	}
}