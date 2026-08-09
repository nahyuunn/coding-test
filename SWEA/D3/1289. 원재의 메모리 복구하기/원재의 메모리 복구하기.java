import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[] origin = br.readLine().toCharArray();
			char target = '0';
			int count = 0;
			for (char ch : origin) {
				if (ch != target) {
					count++;
					target = ch;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

}