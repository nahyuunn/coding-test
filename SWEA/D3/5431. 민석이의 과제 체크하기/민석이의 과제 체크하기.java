import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Set<Integer> set = new TreeSet<>();
			for (int n = 1; n <= N; n++) {
				set.add(n);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				set.remove(Integer.parseInt(st.nextToken()));
			}
            
			sb.append("#").append(t).append(" ");
		
			int length = N - K;
			for (int num: set) {
				sb.append(num);
				if (--length > 0) sb.append(" ");
			}
			if (t != T) sb.append("\n");
		}
		System.out.print(sb);	
	}
}