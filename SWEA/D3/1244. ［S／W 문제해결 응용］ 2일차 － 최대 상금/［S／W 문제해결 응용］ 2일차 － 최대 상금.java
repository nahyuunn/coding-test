import java.util.*;
import java.io.*;

public class Solution {
	static int cnt;
	static int[] nums;
	static int max;
	static Map<Integer, Set<Integer>> map;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String sN = st.nextToken();
			cnt = Integer.parseInt(st.nextToken());

			nums = new int[sN.length()];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sN.charAt(i) - '0';
			}
			max = Integer.MIN_VALUE;
			map = new HashMap<>();
			dfs(0);

			System.out.println("#" + t + " " + max);
		}
		
	}
	
	private static void dfs(int c) {
		int num = toNum();

		if (c == cnt) {
			max = Math.max(max, num);
			return;
		}
		
		if (map.get(c) == null) {
			map.put(c, new HashSet<>());
		}
		
		if (!map.get(c).add(num)) {
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				change(i, j);
				dfs(c+1);
				change(i, j);
			}
		}
	
	}
	
	private static void change(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private static int toNum() {
		int num = 0;
		int unit = 1;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			num += nums[i] * unit;
			unit *= 10;
		}
		
		return num;
	}

}