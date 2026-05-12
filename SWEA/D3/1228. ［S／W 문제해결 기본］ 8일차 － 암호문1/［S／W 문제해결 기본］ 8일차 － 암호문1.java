import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            List<String> list = new ArrayList<>();
            while (N-- > 0) {
                list.add(st1.nextToken());
            }

            int fc = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine(), "I");

            for (int i = 0; i < fc; i++) {
                String[] funcArr = st2.nextToken().split(" ");

                int x = Integer.parseInt(funcArr[1]);
                int y = Integer.parseInt(funcArr[2]);

                for (int n = 3; n < y + 3; n++) {
                    list.add(x++, funcArr[n]);
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