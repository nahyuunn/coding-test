import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int maxMethod = nums.length/2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        if (set.size() < maxMethod) return set.size();
        else return maxMethod;
   }
}