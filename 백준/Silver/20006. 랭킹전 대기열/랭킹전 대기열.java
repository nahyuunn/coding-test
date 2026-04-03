import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Set<String>> room = new LinkedHashMap<>();
        HashMap<String,Integer> levels = new HashMap<>();

        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            enterRoom(lv, n, m, room, levels);
        }

        for (Set<String> set : room.values()) {
            if (set.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            for (String n : set) {
                sb.append(levels.get(n)).append(" ").append(n).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void enterRoom(int lv, String n, int m, LinkedHashMap<String, Set<String>> room, HashMap<String,Integer> levels) {
        levels.put(n, lv);

        for (String h : room.keySet()) {
            int roomLv = levels.get(h);
            if (lv >= roomLv -10 && lv <= roomLv + 10) {
                if (room.get(h).size() < m) {
                    room.get(h).add(n);
                    return;
                }
            }
        }
        room.put(n, new TreeSet<>());
        room.get(n).add(n);
    }
}
