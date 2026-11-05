import java.util.Arrays;
/**
 * [프로그래머스] 서버 증설 횟수
 * https://school.programmers.co.kr/learn/courses/30/lessons/389479
 * Level 2 | 연습문제
 */
public class ServerExpansionCount {
  public static int solution(int[] players, int m, int k) {
    int answer = 0;
    int activeServers = 0;

    // 각 시간에 증설한 서버 수
    int[] addedServers = new int[24];

    for (int i = 0; i < 24; i++) {

      // 1. 운영 시간이 끝난 서버 반납
      if (i >= k) {
        activeServers -= addedServers[i - k];
      }

      // 2. 현재 시간에 필요한 서버 수
      int requiredServers = players[i] / m;

      // 3. 부족한 서버 수 계산
      int need = requiredServers - activeServers;

      // 4. 부족할 때만 서버 증설
      if (need > 0) {
        activeServers += need;
        addedServers[i] = need;
        answer += need;
      }
    }

    return answer;
  }

  public static void test(
      String name,
      int[] players,
      int m,
      int k,
      int expected) {
    int actual = solution(players, m, k);

    if (actual != expected) {
      throw new AssertionError(
          name + " 실패! expected=" + expected
              + ", actual=" + actual);
    }

    System.out.println(name + " PASS : " + actual);
  }

  public static void main(String[] args) {

    // 테스트 1: 문제 예제
    test("예제 1",
        new int[] {
            0, 2, 3, 3, 1, 2, 0, 0,
            0, 0, 4, 2, 0, 6, 0, 4,
            2, 13, 3, 5, 10, 0, 1, 5
        },
        3, 5, 7);

    // 테스트 2: k = 1
    test("예제 2",
        new int[] {
            0, 0, 0, 10, 0, 12, 0, 15,
            0, 1, 0, 1, 0, 0, 0, 5,
            0, 0, 11, 0, 8, 0, 0, 0
        },
        5, 1, 11);

    // 테스트 3: m = 1, k = 1
    test("예제 3",
        new int[] {
            0, 0, 0, 0, 0, 2, 0, 0,
            0, 1, 0, 5, 0, 2, 0, 1,
            0, 0, 0, 0, 0, 0, 0, 1
        },
        1, 1, 12);

    // 테스트 4: 이용자가 없는 경우
    test("이용자 없음",
        new int[24],
        3, 5, 0);

    // 테스트 5: 하루 종일 서버 1대 필요
    int[] allDay = new int[24];
    Arrays.fill(allDay, 3);

    test("하루 종일 이용",
        allDay,
        3, 5, 5);

    // 테스트 6: 서버가 24시간 운영
    test("24시간 운영",
        allDay,
        3, 24, 1);

    // 테스트 7: 0시에만 10명 이용
    int[] firstHour = new int[24];
    firstHour[0] = 10;

    test("0시에만 이용",
        firstHour,
        3, 5, 3);

    // 테스트 8: 0시와 5시에 이용
    int[] expiration = new int[24];
    expiration[0] = 3;
    expiration[5] = 3;

    test("만료 시점 재증설",
        expiration,
        3, 5, 2);

    System.out.println("모든 테스트 통과!");
  }
}
