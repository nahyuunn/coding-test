import java.util.*;
import java.io.*;

public class Solution {
	
	static int[][] drt = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			String[][] board = new String[4][4];
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken();
				}
			}
			Set<String> set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					String str = "";
					str += board[i][j];
					dfs(i, j, str, board, set);
				}
			}
			sb.append("#").append(t).append(" ").append(set.size());
			if (t != T) sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int i, int j, String str, String[][] board, Set<String> set) {
		if (str.length() == 7) {
			set.add(str);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nxtI = i + drt[d][0];
			int nxtJ = j + drt[d][1];
			
			if (nxtI >= 0 && nxtI < board.length && nxtJ >= 0 && nxtJ < board.length) {
				dfs(nxtI, nxtJ, str + board[nxtI][nxtJ], board,  set);
			}
		}
		return;
	}
}