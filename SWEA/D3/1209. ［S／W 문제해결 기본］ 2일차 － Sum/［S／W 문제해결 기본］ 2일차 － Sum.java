import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, int[][]> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int TC = Integer.parseInt(br.readLine());
            map.put(TC, new int[100][100]);

            for (int j = 0; j < 100; j++) {
                StringTokenizer st  = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    map.get(TC)[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Math.max(getCrossMax(map.get(TC)), getRCMax(map.get(TC)));

            sb.append("#").append(TC).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int getRCMax(int[][] cur) {
        int rowSumMax = 0;
        int colSumMax = 0;

        for (int i = 0; i < 100; i++) {
            int curRowSum = 0;
            int curColSum = 0;
            for (int j = 0; j < 100; j++) {
                curRowSum += cur[i][j];
                curColSum += cur[j][i];
            }
            rowSumMax = Math.max(rowSumMax, curRowSum);
            colSumMax = Math.max(curColSum, colSumMax);
        }
        return  Math.max(rowSumMax, colSumMax);
    }

    private static int getCrossMax(int[][] cur) {
        int leftCross = 0;
        int rightCross = 0;
        for (int i = 0; i < 100; i++) {
            leftCross += cur[i][i];
            rightCross += cur[i][99-i];
        }
        return Math.max(leftCross, rightCross);
    }
}
