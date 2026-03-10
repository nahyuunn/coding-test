import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            boolean answer = true;
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        answer = false;
                        break;
                    } else stack.pop();
                }
            }
            if (!stack.isEmpty()) answer = false;
            sb.append(answer ? "YES" : "NO").append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}