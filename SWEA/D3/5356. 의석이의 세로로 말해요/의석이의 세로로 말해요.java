import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            List<List<Character>> list = new ArrayList<>();

            int max = 0;
            for (int i = 0; i < 5; i++) {
                list.add(i, new ArrayList<>());
                char[] arr = br.readLine().toCharArray();
                for (char c: arr) {
                    list.get(i).add(c);
                }
                max = Math.max(max, arr.length);
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 5; j++) {
                    if (list.get(j).size() > i) {
                        str.append(list.get(j).get(i));
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(str);
            if (t != tc) sb.append("\n");
        }
        System.out.print(sb);
    }
}