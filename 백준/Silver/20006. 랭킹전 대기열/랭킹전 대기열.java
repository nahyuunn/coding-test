import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Map<String, Set<String>> rooms = new LinkedHashMap<>();
        Map<String, Integer> levels = new HashMap<>();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int nowLv = Integer.parseInt(st.nextToken());
            String nowNickname = st.nextToken();

            String room = findRoom(nowLv, m, rooms, levels);

            if (room == null) {
                rooms.put(nowNickname, new TreeSet<>());
                rooms.get(nowNickname).add(nowNickname);
            } else {
                rooms.get(room).add(nowNickname);
            }
            levels.put(nowNickname, nowLv);
        }

        for (Map.Entry<String, Set<String>> entry : rooms.entrySet()) {
            if (entry.getValue().size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            for (String nxt : entry.getValue()) {
                sb.append(levels.get(nxt) + " " + nxt + "\n");
            }
        }
        System.out.println(sb);
    }

    static String findRoom(int level, int size, Map<String, Set<String>> rooms, Map<String, Integer> levels) {
        for (String key : rooms.keySet()) {
            int roomLevel = levels.get(key);
            if (level >= roomLevel - 10 && level <= roomLevel + 10) {
                if (rooms.get(key).size() < size) {
                    return key;
                }
            }
        }
        return null;
    }
}
