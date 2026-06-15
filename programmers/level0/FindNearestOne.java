/**
 * [프로그래머스] 가까운 1 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181898
 * Level 0
 */
public class FindNearestOne {
  public int solution(int[] arr, int idx) {

    for (int i = idx; i < arr.length; i++) {
      if (arr[i] == 1) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {

    FindNearestOne sol = new FindNearestOne();

    // 테스트 1
    int[] arr1 = { 0, 0, 0, 1 };
    System.out.println(sol.solution(arr1, 1)); // 3

    // 테스트 2
    int[] arr2 = { 1, 0, 0, 1, 0, 0 };
    System.out.println(sol.solution(arr2, 4)); // -1

    // 테스트 3
    int[] arr3 = { 1, 1, 1, 1, 0 };
    System.out.println(sol.solution(arr3, 3)); // 3

    // 추가 테스트 4
    int[] arr4 = { 1, 0, 0, 0 };
    System.out.println(sol.solution(arr4, 0)); // 0

    // 추가 테스트 5
    int[] arr5 = { 0, 1, 0, 1, 0 };
    System.out.println(sol.solution(arr5, 2)); // 3
  }
}
