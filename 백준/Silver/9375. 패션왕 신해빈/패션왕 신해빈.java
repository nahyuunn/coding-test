import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            makeKindMap(n);
            getAnswer();
        }
        System.out.println(sb);
    }
    
    static void makeKindMap(int n)  throws IOException {
        map = new HashMap<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            String kind = st.nextToken();
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
    }
    
    static void getAnswer() {
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        sb.append(answer-1).append("\n");
    }
}
