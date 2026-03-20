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
      int x1 = queries[q][0];
      int y1 = queries[q][1];
      int x2 = queries[q][2];
      int y2 = queries[q][3];

      int min = Integer.MAX_VALUE;
      int temp = board[x1 - 1][y1 - 1]; // 시작값 저장
      min = Math.min(min, temp);

      // 윗줄: 왼→오
      for (int i = y1 - 1; i < y2 - 1; i++) {
        board[x1 - 1][i] = board[x1 - 1][i + 1];
        min = Math.min(min, board[x1 - 1][i]);
      }

      // 오른줄: 위→아래
      for (int i = x1 - 1; i < x2 - 1; i++) {
        board[i][y2 - 1] = board[i + 1][y2 - 1];
        min = Math.min(min, board[i][y2 - 1]);
      }

      // 아랫줄: 오→왼
      for (int i = y2 - 1; i > y1 - 1; i--) {
        board[x2 - 1][i] = board[x2 - 1][i - 1];
        min = Math.min(min, board[x2 - 1][i]);
      }

      // 왼줄: 아래→위
      for (int i = x2 - 1; i > x1 - 1; i--) {
        board[i][y1 - 1] = board[i - 1][y1 - 1];
        min = Math.min(min, board[i][y1 - 1]);
      }

      // temp(시작값)를 왼줄 맨 위 바로 아래에 넣기
      board[x1][y1 - 1] = temp;
      min = Math.min(min, temp);

      answer[q] = min;
    }
    return answer;
  }

  public static void main(String[] args) {
    MatrixBorderRotation m = new MatrixBorderRotation();
    int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
    int[] result = m.solution(6, 6, queries);
    for (int r : result)
      System.out.print(r + " "); // 기댓값: 8 10 25
  }
}
