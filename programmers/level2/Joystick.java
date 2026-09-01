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
    int rotSum = 0;

    for (int i = 0; i < n; i++) {
      int charIdx = name.charAt(i) - 'A';
      rotSum += Math.min(charIdx, 26 - charIdx);
    }

    List<Integer> positions = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (name.charAt(i) != 'A') {
        positions.add(i);
      }
    }

    if (positions.isEmpty()) {
      return rotSum;
    }

    int pm = positions.get(positions.size() - 1);
    int minMove = pm;

    for (int i = 0; i < positions.size() - 1; i++) {
      int pi = positions.get(i);
      int candidate = 2 * pi + n - (positions.get(i+1));
      if (candidate < minMove) {
        minMove = candidate;
      }
    }

    return rotSum + minMove;
  }

  public static void main(String[] args) {
    Joystick sol = new Joystick();
    System.out.println(sol.solution("JEROEN")); // 56
    System.out.println(sol.solution("JAN")); // 23
    System.out.println(sol.solution("ABABAAAAAAA")); // 5
  }
}
