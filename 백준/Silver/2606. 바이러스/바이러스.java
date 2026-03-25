import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());
            map.get(start).add(to);
            map.get(to).add(start);
        }

        int count = bfs(map, new boolean[c+1]);

        System.out.println(count);
    }

    static int bfs(Map<Integer, List<Integer>> map, boolean[] visited) {
        int count = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur != 1) count++;
            if (map.get(cur) == null) continue;
            for (int nxt : map.get(cur)) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
        return count;
    }
}