/**
 * [프로그래머스] 첫 번째로 나오는 음수
 * https://school.programmers.co.kr/learn/courses/30/lessons/181896
 * Level 0
 */
public class FindFirstNegative {
  public int solution(int[] num_list) {
    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] < 0) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    FindFirstNegative solution = new FindFirstNegative();

    System.out.println(solution.solution(
        new int[] { 12, 4, 15, 46, 38, -2, 15 })); // 5

    System.out.println(solution.solution(
        new int[] { 13, 22, 53, 24, 15, 6 })); // -1

    System.out.println(solution.solution(
        new int[] { -5, 10, 20, 30, 40 })); // 0
  }
}
