/**
 * [프로그래머스] 푸드 파이터 대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * Level 1 | 연습문제
 */
public class FoodFight {

  public String solution(int[] food) {
    StringBuilder left = new StringBuilder();

    for (int i = 1; i < food.length; i++) {
      int count = food[i] / 2;

      for (int j = 0; j < count; j++) {
        left.append(i);
      }
    }

    String right = new StringBuilder(left).reverse().toString();

    return left + "0" + right;
  }

  public static void main(String[] args) {

    FoodFight foodFight = new FoodFight();

    // 테스트 1
    int[] food1 = { 1, 3, 4, 6 };
    System.out.println("테스트 1");
    System.out.println("결과: " + foodFight.solution(food1));
    System.out.println("정답: 1223330333221");
    System.out.println();

    // 테스트 2
    int[] food2 = { 1, 7, 1, 2 };
    System.out.println("테스트 2");
    System.out.println("결과: " + foodFight.solution(food2));
    System.out.println("정답: 111303111");
    System.out.println();

    // 테스트 3
    int[] food3 = { 1, 2, 4, 6 };
    System.out.println("테스트 3");
    System.out.println("결과: " + foodFight.solution(food3));
    System.out.println("정답: 1223330333221");
    System.out.println();

    // 테스트 4
    int[] food4 = { 1, 5, 3 };
    System.out.println("테스트 4");
    System.out.println("결과: " + foodFight.solution(food4));
    System.out.println("정답: 112303211");
  }
}