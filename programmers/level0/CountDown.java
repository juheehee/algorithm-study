/**
 * [프로그래머스] 카운트 다운
 * https://school.programmers.co.kr/learn/courses/30/lessons/181899
 * Level 0 | 연습문제
 */
public class CountDown {
  public int[] solution(int start_num, int end_num) {
    int[] answer = new int[start_num - end_num + 1];
    for (int i = start_num; i >= end_num; i--) {
      answer[start_num - i] = i;
    }
    return answer;
  }

  public static void main(String[] args) {
    CountDown sol = new CountDown();
    int[] result = sol.solution(10, 3);
    System.out.println(java.util.Arrays.toString(result));
    // 기대값: [10, 9, 8, 7, 6, 5, 4, 3]
  }
}
