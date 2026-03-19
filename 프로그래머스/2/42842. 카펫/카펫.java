class Solution {
    public int[] solution(int brown, int yellow) {
        int extent = brown + yellow;
        int[] answer = new int[2];

        for (int i = 1; i * i <= extent ; i++) {
            if (extent % i == 0) {
                int a = extent/i;
                int b = i;
                if ((a-2) * (b-2) == yellow) {
                    answer[0] = Math.max(a,b);
                    answer[1] = Math.min(a,b);
                }

            }
        }
        return answer;
    }
}