/**
 * [프로그래머스] 택배 상자 꺼내기
 * https://school.programmers.co.kr/learn/courses/30/lessons/389478
 * Level 1 | 연습문제
 */
public class DeliveryBox {
  public int solution(int n, int w, int num) {
    int targetCol = getCol(num, w);
    int answer = 0;

    for (int box = num; box <= n; box++) {
      if (getCol(box, w) == targetCol) {
        answer++;
      }
    }

    return answer;
  }

  private int getCol(int box, int w) {
    int row = (box - 1) / w;
    int pos = (box - 1) % w;

    if (row % 2 == 0) {
      return pos;
    } else {
      return w - 1 - pos;
    }
  }

  public static void main(String[] args) {
    DeliveryBox solution = new DeliveryBox();

    int result1 = solution.solution(22, 6, 8);
    System.out.println("test1 실행값 : " + result1);

    int result2 = solution.solution(13, 3, 6);
    System.out.println("test2 실행값 : " + result2);
  }
}
