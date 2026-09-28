/**
 * [프로그래머스] 노란불 신호등
 * https://school.programmers.co.kr/learn/courses/30/lessons/468371
 * Level 1 | 연습문제
 */
public class YellowTrafficLight {

    public int solution(int[][] signals) {
        // 모든 주기의 최소공배수 = 탐색 상한 (이후엔 패턴 반복)
        long lcm = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            lcm = lcm / gcd(lcm, cycle) * cycle; // 오버플로우 방지 순서
        }

        for (int t = 1; t <= lcm; t++) {
            boolean allYellow = true;
            for (int[] s : signals) {
                int cycle = s[0] + s[1] + s[2];
                int r = (t - 1) % cycle;          // 1초에 초록 시작 → offset 0
                if (!(s[0] <= r && r < s[0] + s[1])) {
                    allYellow = false;
                    break;                        // 하나라도 노란불 아니면 다음 t
                }
            }
            if (allYellow) return t;
        }
        return -1;
    }

    // 유클리드 호제법 (재귀 버전)
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        YellowTrafficLight sol = new YellowTrafficLight();

        int[][] signals1 = {{2, 1, 2}, {5, 1, 1}};
        int result1 = sol.solution(signals1);
        System.out.println(result1);

        int[][] signals2 = {{2, 3, 2}, {3, 1, 3}, {2, 1, 1}};
        int result2 = sol.solution(signals2);
        System.out.println(result2);

        int[][] signals3 = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};
        int result3 = sol.solution(signals3);
        System.out.println(result3);

        int[][] signals4 = {{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}};
        int result4 = sol.solution(signals4);
        System.out.println(result4);
    }
}