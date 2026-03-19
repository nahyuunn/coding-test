class Solution {
    public int solution(int[][] sizes) {
        int w = 1;
        int h = 1;
        for (int[] size : sizes) {
            int l = Math.max(size[0], size[1]);
            int s = Math.min(size[0], size[1]);
            w = (l > w) ? l : w;
            h = (s > h) ? s : h;
        }
        return w * h;
    }
}