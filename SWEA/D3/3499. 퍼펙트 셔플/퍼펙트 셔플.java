import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tn = 1; tn <= T; tn++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<String> q1 = new ArrayDeque<>();
            Queue<String> q2 = new ArrayDeque<>();

            int center = N % 2 == 0 ? (N / 2) : (N / 2 + 1);

            for(int n = 0; n < N; n++) {
                if (n < center) {
                    q1.offer(st.nextToken());
                } else {
                    q2.offer(st.nextToken());
                }
            }
            
            sb.append("#").append(tn).append(" ");

            for (int n = 0; n < N; n++) {
                if (n % 2 == 0) {
                    if (!q1.isEmpty()) sb.append(q1.poll());
                } else {
                    if (!q2.isEmpty()) sb.append(q2.poll());
                }
                if (n < N-1) sb.append(" ");
            }
            if (tn != T) sb.append("\n");
        }
        System.out.println(sb);
    }
}