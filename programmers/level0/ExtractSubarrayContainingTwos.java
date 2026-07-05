import java.util.Arrays;

/**
 * [프로그래머스] 2의 영역
 * https://school.programmers.co.kr/learn/courses/30/lessons/181894
 * Level 0 | 연습문제
 */
public class ExtractSubarrayContainingTwos {
  public int[] solution(int[] arr) {
    int start = -1;
    int end = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 2) {
        if (start == -1) {
          start = i;
        }
        end = i;
      }
    }

    if (start == -1) {
      return new int[] { -1 };
    }

    return Arrays.copyOfRange(arr, start, end + 1);
  }

  public static void main(String[] args) {
    ExtractSubarrayContainingTwos solution = new ExtractSubarrayContainingTwos();

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 2, 1, 4, 5, 2, 9 }))); // [2, 1, 4, 5, 2]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 2, 1 }))); // [2]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 1, 1 }))); // [-1]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 2, 1, 2, 1, 10, 2, 1 }))); // [2, 1, 2, 1, 10, 2]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 2 }))); // [2]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 2, 2, 2 }))); // [2, 2, 2]

    System.out.println(Arrays.toString(
        solution.solution(new int[] { 1, 1, 2, 1, 1 }))); // [2]
  }
}
