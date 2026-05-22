import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int [100];
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int d = 0; d < dump; d++) {
				Arrays.sort(box);
				if (Math.abs(box[0] - box[99]) <= 1) break;
				box[0]++;
				box[99]--;
			}
			Arrays.sort(box);

			int ans = box[99] - box[0];
			System.out.println("#" + t + " " + ans);
		}
	}
}