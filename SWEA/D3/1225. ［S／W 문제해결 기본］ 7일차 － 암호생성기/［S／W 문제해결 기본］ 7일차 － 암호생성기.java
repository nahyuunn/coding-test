import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) {
            int tn = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            while(flag) {
                for (int t = 1; t <= 5; t++) {
                    int cur = q.poll() - t;
                    if (cur > 0) {
                        q.offer(cur);
                    } else {
                        q.offer(0);
                        flag = false;
                        break;
                    }
                }
            }

            sb.append("#").append(tn).append(" ");

            while(!q.isEmpty()) {
                sb.append(q.poll());
                if (!q.isEmpty()) sb.append(" ");
            }
            if (tc != 9) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}