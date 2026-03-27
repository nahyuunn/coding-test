import java.util.*;

class Solution {
    String[] aeiou = {"A", "E", "I", "O", "U"};
    public int solution(String word) {

        PriorityQueue<String> words = new PriorityQueue<>();
        
        dfs("", words);
        int answer = 0;

        while (!words.isEmpty()) {
            answer++;
            if (words.poll().equals(word)) {
                break;
            }
        }
        return answer;
    }
    
    void dfs(String word, PriorityQueue<String> words) {

        if (!word.equals("")) {
            words.offer(word);
        };
        
        if (word.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(word + aeiou[i], words);
        }
    }
}