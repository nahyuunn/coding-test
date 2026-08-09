import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String origin = br.readLine();
			char cur = '0';
			int count = 0;
			for (int i = 0; i < origin.length(); i++) {
				char ch = origin.charAt(i);
				if (ch != cur) {
					count++;
					cur = ch;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

}