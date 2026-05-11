import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Character> list = new ArrayList<>();
            String str = st.nextToken();
            for (char c : str.toCharArray()) {
                list.add(c);
            }
            for (int i = 0; i < count - 1; i++) {
                if (list.get(i) == list.get(i+1)) {
                    list.remove(i);
                    list.remove(i);
                    i = -1;
                    count -= 2;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (char c: list) {
                sb.append(c);
            }
            if (tc != 10) sb.append("\n");
        }
        System.out.print(sb);
    }
}