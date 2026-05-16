/**
 * [프로그래머스] 마지막 두 원소
 * https://school.programmers.co.kr/learn/courses/30/lessons/181927
 * Level 0 | 연습문제
 */
public class LastTwoElements {
  public int[] solution(int[] num_list) {

    int last = num_list.length - 1;
    int front = num_list.length - 2;

    int value;

    if (num_list[last] > num_list[front]) {
      value = num_list[last] - num_list[front];
    } else {
      value = num_list[last] * 2;
    }

    int[] answer = new int[num_list.length + 1];

    for (int i = 0; i < num_list.length; i++) {
      answer[i] = num_list[i];
    }

    answer[num_list.length] = value;

    return answer;
  }

  public static void main(String[] args) {

    LastTwoElements solution = new LastTwoElements();

    // 테스트 1
    printArray(solution.solution(new int[] { 2, 1, 6 }));
    // [2, 1, 6, 5]

    // 테스트 2
    printArray(solution.solution(new int[] { 5, 2, 1, 7, 5 }));
    // [5, 2, 1, 7, 5, 10]

    // 테스트 3
    printArray(solution.solution(new int[] { 3, 3 }));
    // [3, 3, 6]

    // 테스트 4
    printArray(solution.solution(new int[] { 9, 1 }));
    // [9, 1, 0]
  }

  public static void printArray(int[] arr) {

    System.out.print("[");

    for (int i = 0; i < arr.length; i++) {

      System.out.print(arr[i]);

      if (i != arr.length - 1) {
        System.out.print(", ");
      }
    }

    System.out.println("]");
  }
}
