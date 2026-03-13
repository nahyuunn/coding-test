import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            map.put(i, new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        dfs(V, map, new boolean[N+1]);
        sb.append("\n");
        bfs(V, map, new boolean[N+1]);

        System.out.println(sb);
    }

    private static void dfs(int cur, Map<Integer, Set<Integer>> map, boolean[] visited) {
        visited[cur] = true;
        sb.append(cur).append(" ");
        
        for (int next : map.get(cur)) {
            if (!visited[next]) {
                dfs(next, map, visited);
            }
        }
    }

    private static void bfs(int V, Map<Integer, Set<Integer>> map, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            
            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}