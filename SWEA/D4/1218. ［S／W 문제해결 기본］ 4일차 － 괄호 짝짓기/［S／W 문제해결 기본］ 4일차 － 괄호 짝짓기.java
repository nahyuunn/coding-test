import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
		
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			ArrayDeque<Character> q = new ArrayDeque<>();
			for (int i = 0; i < length; i++) {
				char now = str.charAt(i);
				if (now == '(' || now == '{' || now == '[' || now == '<') {
					q.offer(now);
				} else {					
					if (now == ')') {
						if (q.peekLast() == '(') {
							q.pollLast();
						} else break;
					} else if (now == '}') {
						if (q.peekLast() == '{') {
							q.pollLast();
						} else break;
					} else if (now == ']') {
						if (q.peekLast() == '[') {
							q.pollLast();
						} else break;
					} else if (now == '>') {
						if (q.peekLast() == '<') {
							q.pollLast();
						} else break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(q.isEmpty() ? 1 : 0);
			if (t != 10) sb.append("\n");
		}
		System.out.println(sb);
	}
}