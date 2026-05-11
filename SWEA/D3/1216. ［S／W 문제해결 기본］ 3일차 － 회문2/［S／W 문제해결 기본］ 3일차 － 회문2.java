import java.io.*;

class Solution {
    static int tc = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int tn = Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                arr[i] = str.toCharArray();
            }
            int length = Math.max(findR(arr, 100), findC(arr, 100));
            sb.append("#").append(tn).append(" ").append(length);
            if (tc != 0)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findR(char[][] arr, int max) {
        if (max == 1) return max;
        for (int n = 0; n < 100; n++) {
            for (int i = 0; i <= 100 -  max; i++) {
                boolean isP = true;
                for (int a = 0; a < max / 2; a++) {
                    if (arr[n][i + a] != arr[n][i + max - a - 1]) {
                        isP = false;
                        break;
                    }
                }
                if (isP) return max;
            }
        }
        return findR(arr, max - 1);
    }

    private static int findC(char[][] arr, int max) {
        if (max == 1) return max;
        for (int n = 0; n < 100; n++) {
            for (int i = 0; i <= 100 -  max; i++) {
                boolean isP = true;
                for (int a = 0; a < max / 2; a++) {
                    if (arr[i + a][n] != arr[i + max - a - 1][n]) {
                        isP = false;
                        break;
                    }
                }
                if (isP) return max;
            }
        }
        return findC(arr, max - 1);
    }
}