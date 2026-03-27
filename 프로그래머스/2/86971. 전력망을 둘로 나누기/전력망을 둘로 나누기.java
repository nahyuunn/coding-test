import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int[] wire: wires) {
            map.putIfAbsent(wire[0], new HashSet<>());
            map.putIfAbsent(wire[1], new HashSet<>());
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        int ans = 100;

        for (int i = 0; i < wires.length; i++) {
            int curA = wires[i][0];
            int curB = wires[i][1];
            
            boolean[] visited = new boolean[map.size() + 1];

            map.get(curA).remove(curB);
            map.get(curB).remove(curA);
            ans = Math.min(ans, Math.abs(bfs(curA, map, visited) - bfs(curB, map, visited)));
            map.get(curA).add(curB);
            map.get(curB).add(curA);
        }
        return ans;
    }
    
    int bfs(int start, Map<Integer, Set<Integer>> map, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        
        int count = 0;
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int nxt : map.getOrDefault(cur, new HashSet<>())) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
        return count;
    }
}