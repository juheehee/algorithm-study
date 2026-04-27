/**
 * [프로그래머스] 이어 붙인 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/181928
 * Level 0 | 연습문제
 */
public class SumOfConcatenatedOddsAndEvens {

  public int solution(int[] num_list) {
    StringBuilder odd = new StringBuilder();
    StringBuilder even = new StringBuilder();

    for (int num : num_list) {
      if (num % 2 == 0) {
        even.append(num);
      } else {
        odd.append(num);
      }
    }

    int oddNum = Integer.parseInt(odd.toString());
    int evenNum = Integer.parseInt(even.toString());

    return oddNum + evenNum;
  }

  public static void main(String[] args) {
    SumOfConcatenatedOddsAndEvens obj = new SumOfConcatenatedOddsAndEvens();

    int[] test1 = { 3, 4, 5, 2, 1 };
    int[] test2 = { 5, 7, 8, 3 };

    System.out.println(obj.solution(test1)); // 기대값: 393
    System.out.println(obj.solution(test2)); // 기대값: 581
  }
}