package level3;

import java.util.Scanner;

/**
 * [프로그래머스] 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * Level 3 | 연습문제
 */

public class IntegerTriangle {
  public int solution(int[][] triangle) {
    int n = triangle.length;

    // 아래에서 두 번째 행부터 위로 올라가며 dp 갱신 (triangle 배열 자체를 dp로 재사용)
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
      }
    }
    return triangle[0][0];
  }

  public static void main(String[] args) {
    int[][] triangle = {
        { 7 },
        { 3, 8 },
        { 8, 1, 0 },
        { 2, 7, 4, 4 },
        { 4, 5, 2, 6, 5 }
    };

    IntegerTriangle sol = new IntegerTriangle();
    System.out.println(sol.solution(triangle)); // 30 나와야 함
  }
}
