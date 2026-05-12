import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            String[] list = new String[5];

            int max = 0;
            for (int i = 0; i < 5; i++) {
                list[i] = br.readLine();
                max = Math.max(max, list[i].length());
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 5; j++) {
                    if (list[j].length() > i) {
                        str.append(list[j].charAt(i));
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(str);
            if (t != tc) sb.append("\n");
        }
        System.out.print(sb);
    }
}