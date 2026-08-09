import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] o = new String[N];
			for (int n = 0; n < N; n++) {
				o[n] = br.readLine();
			}
			int count = 0;
			k:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (o[i].charAt(j) == 'o') {
						for (int d = 0; d < 4; d++) {
							count = 1;
							int nxtI = i + dir[d][0];
							int nxtJ = j + dir[d][1];
							
							while (nxtI >= 0 && nxtI < N && nxtJ >= 0 && nxtJ < N) {
								if (o[nxtI].charAt(nxtJ) == 'o') {
									count++;
								} else {
									break;
								}
								if (count == 5) {
									break k;
								}
								nxtI += dir[d][0];
								nxtJ += dir[d][1];
							}
						}
						
					}
				}
			}
			
			String ans = count == 5 ? "YES" : "NO";
			System.out.println("#" + t + " " + ans);
		}

	}
}