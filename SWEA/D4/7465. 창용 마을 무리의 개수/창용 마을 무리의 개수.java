import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(i, new ArrayList<>());
			}
			
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			boolean[] visited = new boolean[N+1];
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i, N, list, visited);
					count++;
				}
			}

			sb.append("#").append(t).append(" ").append(count);
			if (t != T) sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int i, int N, List<List<Integer>> list, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();

		visited[i] = true;
		q.offer(i);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			if (list.get(now) != null) {
				for (int nxt: list.get(now)) {
					if (!visited[nxt]) {
						q.offer(nxt);
						visited[nxt] = true;
					}
				}
			}
		}
	}
}