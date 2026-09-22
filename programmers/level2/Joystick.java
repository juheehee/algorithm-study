package level2;

import java.util.LinkedList;
import java.util.List;

/**
 * [프로그래머스] 조이스틱
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * Level 2 | 연습문제
 */
public class Joystick {
  public int solution(String name) {
    int n = name.length();
    // 1. 알파벳 변경 횟수
    int answer = 0;

    for (int i = 0; i < n; i++) {
      char c = name.charAt(i);

      // 위로 이동하는 경우: A -> B -> ... -> Z
      // 아래로 이동하는 경우: A -> Z -> ... -> B
      answer += Math.min(c - 'A', 'Z' - c + 1);
    }

    // 2. 커서 이동 횟수
    int move = n - 1; // 모든 문자를 오른쪽으로만 이동하는 기본 경우

    for (int i = 0; i < n; i++) {
      int next = i + 1; // i 다음부터 연속된 A의 시작 위치
      while (next < n && name.charAt(next) == 'A') {
        next++;
      }

      int rightThenLeft = i * 2 + (n - next); // 오른쪽으로 갔다가 되돌아오는 경우
      int leftThenRight = i + (n - next) * 2; // 왼쪽으로 갔다가 되돌아오는 경우

      move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
    }

    return answer + move;
  }

  public static void main(String[] args) {
    Joystick sol = new Joystick();
    System.out.println(sol.solution("JEROEN")); // 56
    System.out.println(sol.solution("JAN")); // 23
    System.out.println(sol.solution("ABABAAAAAAA")); // 5
    System.out.println(sol.solution("AAAAAAZ")); // 2
    System.out.println(sol.solution("AAABAAZ")); // 6
    System.out.println(sol.solution("ACXBAAAC")); // 13
  }
}
