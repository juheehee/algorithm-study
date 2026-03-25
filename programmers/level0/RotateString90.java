import java.util.Scanner;
/**
 * [프로그래머스] - 문자열 돌리기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181945
 * Lv.0 | 연습문제 
 */
public class RotateString90 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    for (char c : str.toCharArray()) {
      System.out.println(c);
    }
  }
}
