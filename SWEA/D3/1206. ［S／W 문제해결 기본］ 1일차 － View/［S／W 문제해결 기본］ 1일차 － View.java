import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int[]> bl = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bl.add(new int[N]);

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                bl.get(i)[n] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        int num = 1;

        for (int[] arr: bl) {
            int sum = 0;
            for (int i = 2; i < arr.length - 2 ; i++) {
                int now = arr[i];

                int left = Math.max(arr[i-2], arr[i-1]);
                int right = Math.max(arr[i+1], arr[i+2]);

                if (left <= now && right <= now) {
                    sum += now - Math.max(left, right);
                }
            }
            sb.append("#" + num++ + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}