import java.util.Arrays;
/**
 * [프로그래머스] n 번째 원소부터
 * https://school.programmers.co.kr/learn/courses/30/lessons/181892
 * Level 0 | 연습문제
 */
public class FromNthElement {
  public int[] solution(int[] num_list, int n) {
    return Arrays.copyOfRange(num_list, n - 1, num_list.length);
  }

  public static void main(String[] args) {
    FromNthElement solution = new FromNthElement();

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 2, 1, 6 }, 3))); // [6]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 5, 2, 1, 7, 5 }, 2))); // [2, 1, 7, 5]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 2, 3, 4, 5 }, 1))); // [1, 2, 3, 4, 5]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 2, 3, 4, 5 }, 5))); // [5]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 9, 8 }, 2))); // [8]
  }
}
