/**
 * [프로그래머스] 카운트 업
 * https://school.programmers.co.kr/learn/courses/30/lessons/181920
 * Level 0 | 연습문제
 */
public class CountUp {
  public int[] solution(int start_num, int end_num) {
    int[] answer = new int[end_num - start_num + 1];
    for (int i = start_num; i <= end_num; i++) {
      answer[i - start_num] = i;
    }
    return answer;
  }

  public static void main(String[] args) {
    CountUp sol = new CountUp();
    int[] result = sol.solution(3, 10);
    System.out.println(java.util.Arrays.toString(result));
    // 기대값: [3, 4, 5, 6, 7, 8, 9, 10]
  }
}
