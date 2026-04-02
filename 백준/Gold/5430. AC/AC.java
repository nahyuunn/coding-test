import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            
            ArrayDeque<Integer> adq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                adq.offer(Integer.parseInt(st.nextToken()));
            }
            
            sb.append(func(p, adq)).append("\n");
        }
        System.out.println(sb);
    }

    static String func(String p, ArrayDeque<Integer> adq) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (char c : p.toCharArray()) {
            if (c == 'R') {
                flag = !flag;
            } else if (c == 'D'){
                if (adq.isEmpty()) {
                    return "error";
                } else {
                    if (flag) adq.pollFirst();
                    else adq.pollLast();
                }
            }
        }
        
        if (adq.isEmpty()) return ("[]");

        sb.append("[");
        
        if (flag) {
            while (!adq.isEmpty()) {
                sb.append(adq.pollFirst());
                if (!adq.isEmpty()) {
                    sb.append(",");
                } else {
                    sb.append("]");
                }
            }
        }
        
        else {
            while (!adq.isEmpty()) {
                sb.append(adq.pollLast());
                if (!adq.isEmpty()) {
                    sb.append(",");
                } else {
                    sb.append("]");
                }
            }
        }
        
        return sb.toString();
    }
}
