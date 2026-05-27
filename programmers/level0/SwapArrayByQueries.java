import java.util.Arrays;
/**
 * [프로그래머스] 수열과 구간 쿼리 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/181924
 * Level 0
 */
public class SwapArrayByQueries {
  public int[] solution(int[] arr, int[][] queries) {

    for (int[] query : queries) {

      int i = query[0];
      int j = query[1];

      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    return arr;
  }

  public static void main(String[] args) {

    SwapArrayByQueries sol = new SwapArrayByQueries();

    // 테스트 케이스 1
    int[] arr1 = { 0, 1, 2, 3, 4 };
    int[][] queries1 = {
        { 0, 3 },
        { 1, 2 },
        { 1, 4 }
    };

    System.out.println(Arrays.toString(sol.solution(arr1, queries1)));
    // expected: [3, 4, 1, 0, 2]

    // 테스트 케이스 2
    int[] arr2 = { 10, 20, 30 };
    int[][] queries2 = {
        { 0, 2 }
    };

    System.out.println(Arrays.toString(sol.solution(arr2, queries2)));
    // expected: [30, 20, 10]

    // 테스트 케이스 3
    int[] arr3 = { 5, 6, 7, 8 };
    int[][] queries3 = {
        { 1, 3 },
        { 0, 2 }
    };

    System.out.println(Arrays.toString(sol.solution(arr3, queries3)));
    // expected: [7, 8, 5, 6]
  }
}
