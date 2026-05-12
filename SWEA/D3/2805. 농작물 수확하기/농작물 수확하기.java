import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            int sum = 0;
            int center = N/2;

            for (int m = 0; m < N; m++) {
                for (int j = 0; j < N; j++) {
                    if (m < center) {
                        if (Math.abs(center - j) <= m) {
                            sum += arr[m][j];
                        }
                    } else if (Math.abs(center - j) <= N - 1 - m) {
                        sum += arr[m][j];
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(sum);
            if (t != tc) sb.append("\n");
        }
        System.out.print(sb);
    }
}