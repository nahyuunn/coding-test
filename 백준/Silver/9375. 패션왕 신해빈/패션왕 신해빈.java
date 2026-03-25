import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        
        while (tc-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int answer = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= entry.getValue() + 1;
            }
            sb.append(answer-1).append("\n");
        }
        System.out.println(sb);
    }
}
