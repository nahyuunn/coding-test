import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                list.add(st.nextToken());
            }

            int fc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (fc-- > 0) {
                String cmd = st.nextToken();

                if (cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    while (y-- > 0) {
                        list.add(x++, st.nextToken());
                    }
                }

                if (cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    while (y-- > 0) {
                        list.remove(x);
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i));
                if (i != 9) sb.append(" ");
            }
            if (tc != 10) sb.append("\n");
        }
        System.out.print(sb);
    }
}