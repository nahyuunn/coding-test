import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] gns = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            hm.put(gns[i], i);
        }

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tn = st.nextToken();
            int vn = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new PriorityQueue<>();
            while (vn-- > 0) {
                q.add(hm.get(st.nextToken()));
            }

            sb.append(tn).append("\n");

            while(!q.isEmpty()) {
                sb.append(gns[q.poll()]);
                if (!q.isEmpty()) sb.append(" ");
            }

            if (tc != 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}