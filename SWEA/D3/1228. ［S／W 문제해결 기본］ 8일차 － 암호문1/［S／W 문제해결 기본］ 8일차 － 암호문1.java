import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> list = new ArrayList<>();
            while (N-- > 0) {
                list.add(st.nextToken());
            }

            int fc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < fc; i++) {
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int n = 0; n < y; n++) {
                    list.add(x++, st.nextToken());
                }
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            if (tc != 10) sb.append("\n");
        }
        System.out.print(sb);
    }
}