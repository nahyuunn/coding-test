import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int n = 0; n <N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int max = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i + 1; j < N; j++) {
					int now = arr[i] * arr[j];
					char[] str = String.valueOf(now).toCharArray();

					boolean is = true;
					for (int c = 0; c < str.length - 1; c++) {
						if (str[c] > str[c + 1]) {
							is = false; 
							break;
						}
					}
					if (is) max = Math.max(max, now);
				}
			}
			
			sb.append("#").append(t).append(" ").append(max != 0 ? max : -1);
			if (t != T) sb.append("\n");
		}
		System.out.println(sb);
	}
	
}