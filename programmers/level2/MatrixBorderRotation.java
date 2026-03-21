package level2;

/**
 * [프로그래머스] 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 * Level 2 | 월간 코드 챌린지 시즌2
 */
public class MatrixBorderRotation {
  public int[] solution(int rows, int cols, int[][] queries) {
    // board 초기화 (1부터 rows*cols까지)
    int[][] board = new int[rows][cols];
    int num = 1;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        board[i][j] = num++;

    int[] answer = new int[queries.length];

    for (int q = 0; q < queries.length; q++) {
      int x1 = queries[q][0] - 1;
      int y1 = queries[q][1] - 1;
      int x2 = queries[q][2] - 1;
      int y2 = queries[q][3] - 1;

      int min = Integer.MAX_VALUE;
      int temp = board[x1][y2]; // 오른쪽 위 코너 저장
      min = Math.min(min, temp);

      // 윗줄 : 오 -> 왼
      for (int i = y2; i > y1; i--) {
        board[x1][i] = board[x1][i - 1];
        min = Math.min(min, board[x1][i]);
      }

      // 왼줄 : 위 → 아래
      for (int i = x1; i < x2; i++) {
        board[i][y1] = board[i + 1][y1];
        min = Math.min(min, board[i][y1]);
      }

      // 아랫줄 : 왼 -> 오
      for (int i = y1; i < y2; i++) {
        board[x2][i] = board[x2][i + 1];
        min = Math.min(min, board[x2][i]);
      }

      // 오른줄 : 아래 → 위
      for (int i = x2; i > x1; i--) {
        board[i][y2] = board[i - 1][y2];
        min = Math.min(min, board[i][y2]);
      }

      board[x1 + 1][y2] = temp;

      answer[q] = min;
    }
    return answer;
  }

  public static void main(String[] args) {
    MatrixBorderRotation p = new MatrixBorderRotation();

    int[][] queries1 = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
    int[] result1 = p.solution(6, 6, queries1);
    System.out.print("테스트1: ");
    for (int r : result1)
      System.out.print(r + " ");
    System.out.println("(기댓값: 8 10 25)");

    int[][] queries2 = { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } };
    int[] result2 = p.solution(3, 3, queries2);
    System.out.print("테스트2: ");
    for (int r : result2)
      System.out.print(r + " ");
    System.out.println("(기댓값: 1 1 5 3)");

    int[][] queries3 = { { 1, 1, 100, 97 } };
    int[] result3 = p.solution(100, 97, queries3);
    System.out.print("테스트3: ");
    for (int r : result3)
      System.out.print(r + " ");
    System.out.println("(기댓값: 1)");
  }
}
