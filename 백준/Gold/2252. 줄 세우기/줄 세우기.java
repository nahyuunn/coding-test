import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int c = 1; c <= N; c++) {
            if (inDegree[c] == 0) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (--inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
