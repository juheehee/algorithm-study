import java.util.Arrays;

/**
 * [프로그래머스] 주사위 게임3
 * https://school.programmers.co.kr/learn/courses/30/lessons/181916
 * Level 0
 */
public class DiceGame3 {
  public int solution(int a, int b, int c, int d) {

    int[] dice = { a, b, c, d };
    int[] count = new int[7];

    // 주사위 숫자 개수 세기
    for (int num : dice) {
      count[num]++;
    }

    // 1. 네 개 모두 같은 경우
    for (int i = 1; i <= 6; i++) {
      if (count[i] == 4) {
        return 1111 * i;
      }
    }

    // 2. 세 개가 같은 경우
    for (int i = 1; i <= 6; i++) {
      if (count[i] == 3) {

        int q = 0;

        for (int j = 1; j <= 6; j++) {
          if (count[j] == 1) {
            q = j;
          }
        }

        return (int) Math.pow((10 * i + q), 2);
      }
    }

    // 3. 두 개씩 같은 경우
    int first = 0;
    int second = 0;
    int idx = 0;

    for (int i = 1; i <= 6; i++) {
      if (count[i] == 2) {

        if (idx == 0) {
          first = i;
        } else {
          second = i;
        }

        idx++;
      }
    }

    if (idx == 2) {
      return (first + second) * Math.abs(first - second);
    }

    // 4. 한 쌍만 같은 경우
    for (int i = 1; i <= 6; i++) {

      if (count[i] == 2) {

        int result = 1;

        for (int j = 1; j <= 6; j++) {
          if (count[j] == 1) {
            result *= j;
          }
        }

        return result;
      }
    }

    // 5. 모두 다른 경우
    Arrays.sort(dice);
    return dice[0];
  }

  public static void main(String[] args) {

    DiceGame3 sol = new DiceGame3();

    // 테스트 케이스 1
    System.out.println(sol.solution(2, 2, 2, 2));
    // expected: 2222

    // 테스트 케이스 2
    System.out.println(sol.solution(4, 1, 4, 4));
    // expected: 1681

    // 테스트 케이스 3
    System.out.println(sol.solution(6, 3, 3, 6));
    // expected: 27

    // 테스트 케이스 4
    System.out.println(sol.solution(2, 5, 2, 6));
    // expected: 30

    // 테스트 케이스 5
    System.out.println(sol.solution(6, 4, 2, 5));
    // expected: 2
  }
}
