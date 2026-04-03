import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            ArrayDeque<String> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            
            for (int i = 0; i < n; i++) {
                q.offer(st.nextToken());
            }
            func(p, q);
        }
        System.out.println(sb);
    }

    static void func(String p, ArrayDeque<String> q) {
        boolean flag = true;
        for (char pc : p.toCharArray()) {
            if (pc == 'R') {
                flag = !flag;
            }
            else if (pc == 'D') {
                if (q.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (flag) q.pollFirst();
                else q.pollLast();
            }
        }

        if (q.isEmpty()) {
            sb.append("[]\n");
            return;
        }

        sb.append("[");
        while (!q.isEmpty()) {
            if (flag) sb.append(q.pollFirst());
            else sb.append(q.pollLast());
            if (!q.isEmpty()) sb.append(",");
            else sb.append("]\n");
        }
    }
}

