import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        boolean[] visited = new boolean[N+1];
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i, map, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int n,  Map<Integer, List<Integer>> map, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : map.getOrDefault(cur, new ArrayList<>())) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
