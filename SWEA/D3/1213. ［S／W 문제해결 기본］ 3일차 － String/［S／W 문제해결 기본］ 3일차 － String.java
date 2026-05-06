import java.io.*;

public class Solution {
    static int TC = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            int count = 0;

            int num = Integer.parseInt(br.readLine());
            String target = br.readLine();
            String str = br.readLine();
            
            for (int i = 0; i < str.length() - target.length() + 1; i++) {
                if (target.equals(str.substring(i, i+target.length()))) {
                    count++;
                }
            }
            sb.append("#").append(num).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}