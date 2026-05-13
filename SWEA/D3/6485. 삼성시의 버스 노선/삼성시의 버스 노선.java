import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] range = new int[N][2];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
			
				range[n][0] = Integer.parseInt(st.nextToken());
				range[n][1] = Integer.parseInt(st.nextToken());
			}
			
			int P = Integer.parseInt(br.readLine());

			sb.append("#").append(t).append(" ");
			
			for (int p = 0; p < P; p++) {
				int now = Integer.parseInt(br.readLine());
				int count = 0;
				for (int[] r: range) {
					if (now >= r[0] && now <= r[1]) {
						count++;
					}
				}
				sb.append(count).append(" ");
			}
			if (t != T) sb.append("\n");
		}
		System.out.println(sb);
	}
}