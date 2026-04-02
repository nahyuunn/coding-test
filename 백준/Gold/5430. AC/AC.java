import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
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
        String[] pArr = p.split("");
        boolean flag = true;

        for (String str : pArr) {
            if (str.equals("R")) {
                flag = !flag;
            } else if (str.equals("D")){
                if (adq.isEmpty()) {
                    return "error";
                } else {
                    if (flag) adq.pollFirst();
                    else adq.pollLast();
                }
            }
        }

        sb.append("[");
        
        if (adq.isEmpty()) return ("[]");
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
