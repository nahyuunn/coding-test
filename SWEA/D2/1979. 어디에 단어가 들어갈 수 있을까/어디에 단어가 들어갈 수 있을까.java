import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] p = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					p[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int c = 0;
			int len = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (p[i][j] == 1) len++;
					else {
						if (len == K) {
							c++;
						}
						len = 0;
					}
				}
				if (len == K) c++;
				len = 0;
			}
			
			len = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (p[j][i] == 1) len++;
					else {
						if (len == K) {
							c++;
						} 
						len = 0;
					}
				}
				if (len == K) c++;
				len = 0;
			}
			System.out.println("#" + t + " " + c);
			
		}
	}
}
