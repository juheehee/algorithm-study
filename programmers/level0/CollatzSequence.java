import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [프로그래머스] 콜라츠 수열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181919
 * Level 0
 */

public class CollatzSequence {
  public int[] solution(int n) {

    List<Integer> list = new ArrayList<>();

    while (true) {
      list.add(n);

      if (n == 1) {
        break;
      }

      if (n % 2 == 0) {
        n /= 2;
      } else {
        n = 3 * n + 1;
      }
    }

    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {

    CollatzSequence sol = new CollatzSequence();

    // 테스트 케이스 1
    int n1 = 10;
    System.out.println(Arrays.toString(sol.solution(n1)));
    // expected: [10, 5, 16, 8, 4, 2, 1]

    // 테스트 케이스 2
    int n2 = 1;
    System.out.println(Arrays.toString(sol.solution(n2)));
    // expected: [1]

    // 테스트 케이스 3
    int n3 = 6;
    System.out.println(Arrays.toString(sol.solution(n3)));
    // expected: [6, 3, 10, 5, 16, 8, 4, 2, 1]
  }
}
