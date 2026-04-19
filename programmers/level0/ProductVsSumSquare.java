/**
 * [프로그래머스] 원소들의 곱과 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/181929
 * Level 0 | 연습문제
 */
public class ProductVsSumSquare {
  public int solution(int[] num_list) {
    int sum = 0;
    int product = 1;

    for (int num : num_list) {
      sum += num;
      product *= num;
    }

    return product < (sum * sum) ? 1 : 0;
  }

  public static void main(String[] args) {
    ProductVsSumSquare obj = new ProductVsSumSquare();

    int[] test1 = { 3, 4, 5, 2, 1 };
    int[] test2 = { 5, 7, 8, 3 };

    System.out.println(obj.solution(test1)); // 기대값: 1
    System.out.println(obj.solution(test2)); // 기대값: 0
  }
}
