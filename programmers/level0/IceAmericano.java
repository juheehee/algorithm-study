/**
 * [프로그래머스] 아이스 아메리카노
 * https://school.programmers.co.kr/learn/courses/30/lessons/120819
 * Level 0 | 코딩테스트 입문
 */
public class IceAmericano {
  public int[] solution(int money) {
    int[] answer = new int[2];
    answer[0] = money / 5500;
    answer[1] = money % 5500;
    return answer;
  }

  public static void main(String[] args) {
    IceAmericano sol = new IceAmericano();

    // 테스트 1
    int[] result1 = sol.solution(5500);
    System.out.println(result1[0] + ", " + result1[1]); // 1, 0

    // 테스트 2
    int[] result2 = sol.solution(11500);
    System.out.println(result2[0] + ", " + result2[1]); // 2, 500

    // 테스트 3
    int[] result3 = sol.solution(15000);
    System.out.println(result3[0] + ", " + result3[1]); // 2, 4000
  }
}
