import java.util.ArrayList;
import java.util.Arrays;
/**
 * [프로그래머스] 약수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120897
 * Level 0 | 연습문제
 */
public class DivisorFinder {
  public int[] solution(int n) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
      }
    }

    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    DivisorFinder sol = new DivisorFinder();

    int n1 = 24;
    int[] result1 = sol.solution(n1);
    System.out.println(Arrays.toString(result1));

    int n2 = 29;
    int[] result2 = sol.solution(n2);
    System.out.println(Arrays.toString(result2));
  }
}
