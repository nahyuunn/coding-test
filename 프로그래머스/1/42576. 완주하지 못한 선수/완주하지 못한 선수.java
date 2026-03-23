import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String person: participant) {
            map.putIfAbsent(person, 0);
            map.put(person, map.get(person) +1);
        }
        
        for (String person: completion) {
            int count = map.get(person);
            if (count == 1) map.remove(person);
            else map.put(person, count-1);
        }
        
        for (String person: map.keySet()) {
            answer = person;
        }
        
        return answer;
    }
}