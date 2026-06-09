/**
 * [프로그래머스] 9로 나눈 나머지
 * https://school.programmers.co.kr/learn/courses/30/lessons/181914
 * Level 0
 */
public class RemainderBy9 {

  public int solution(String number) {
    int sum = 0;

    for (char c : number.toCharArray()) {
      sum += c - '0';
    }

    return sum % 9;
  }

  public static void main(String[] args) {
    
    RemainderBy9 sol = new RemainderBy9();

    System.out.println(sol.solution("123")); // 6
    System.out.println(sol.solution("78720646226947352489")); // 2

    // 추가 테스트
    System.out.println(sol.solution("9")); // 0
    System.out.println(sol.solution("18")); // 0
    System.out.println(sol.solution("99999")); // 0
    System.out.println(sol.solution("1")); // 1
    System.out.println(sol.solution("99998")); // 8
  }
}
