import java.io.*;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			int length = Integer.parseInt(br.readLine());
			char[][] board = new char[8][8];
			
			for (int i = 0; i < 8; i++) {
				String now = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = now.charAt(j);
				}
			}
			
			int count = 0;
			for (int c = 0; c < 8; c++) {
				for (int i = 0; i <= 8 - length; i++) {
					boolean isRP = true;
					boolean isCP = true;
					for (int j = 0; j < length; j++) {
						if (isRP && board[c][i + j] != board[c][i + length - j - 1]) {
							isRP = false;
						}
						if (isCP && board[i + j][c] != board[i + length - j - 1][c]) {
							isCP = false;
						}
					}
					
					if (isRP) count++;
					if (isCP) count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}