import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            map.putIfAbsent(cloth[1], new ArrayList<>());
            map.get(cloth[1]).add(cloth[0]);
        }
        
        for (String type : map.keySet()) {
            answer = answer * (map.get(type).size() + 1);
        }        
        
        return answer - 1;
    }
}