import java.util.ArrayList;

/**
 * [프로그래머스] n의 배수 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120905
 * Level 0 | 연습문제
 */
public class MultipleFilter {
  public int[] solution(int n, int[] numlist) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int num : numlist) {
      if (num % n == 0) {
        list.add(num);
      }
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    MultipleFilter sol = new MultipleFilter();

    // n=3, numlist=[5,9,7,10,3,2,4,12] → [9,3,12]
    int[] result1 = sol.solution(3, new int[] { 5, 9, 7, 10, 3, 2, 4, 12 });
    System.out.print("결과1: ");
    for (int v : result1)
      System.out.print(v + " ");
    System.out.println();

    // n=5, numlist=[1,2,3,4,5] → [5]
    int[] result2 = sol.solution(5, new int[] { 1, 2, 3, 4, 5 });
    System.out.print("결과2: ");
    for (int v : result2)
      System.out.print(v + " ");
    System.out.println();

    // n=12, numlist=[2,100,120,600, 12, 12] → [120, 600, 12, 12]
    int[] result3 = sol.solution(12, new int[] { 2, 100, 120, 600, 12, 12 });
    System.out.print("결과3: ");
    for (int v : result3)
      System.out.print(v + " ");
    System.out.println();
  }
}
