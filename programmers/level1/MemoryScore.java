import java.util.HashMap;
import java.util.Map;
/**
 * [프로그래머스] 추억 점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/171963
 * Level 1
 */
public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MemoryScore ms = new MemoryScore();

        // 테스트 1
        String[] name1 = {"may", "kein", "kain", "radi"};
        int[] yearning1 = {5, 10, 1, 3};
        String[][] photo1 = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "radi", "may", "deny"}
        };
        System.out.println(java.util.Arrays.toString(ms.solution(name1, yearning1, photo1)));

        // 테스트 2
        String[] name2 = {"kali", "mari", "don"};
        int[] yearning2 = {11, 1, 55};
        String[][] photo2 = {
            {"valt", "mari", "valt", "valt"},
            {"kon", "kali", "valt", "don"}  // 실제론 kali+don = 11+55 아니라 kali만
        };
        
        System.out.println(java.util.Arrays.toString(ms.solution(name2, yearning2, photo2)));
    }
}