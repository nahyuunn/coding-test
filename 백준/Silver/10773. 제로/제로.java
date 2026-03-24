import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else stack.push(n);
        }

        int sum = 0;
        for (int s : stack) {
            sum += s;
        }
        System.out.println(sum);
    }
}