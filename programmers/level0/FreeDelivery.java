public class FreeDelivery {
  public static void main(String[] args) {
    FreeDelivery sol = new FreeDelivery();

    System.out.println(sol.solution(true, 10000)); // true (VIP라서)
    System.out.println(sol.solution(false, 35000)); // true (3만원 이상이라서)
    System.out.println(sol.solution(true, 40000)); // true (둘 다 만족)
    System.out.println(sol.solution(false, 20000)); // false (둘 다 안 됨)
  }

  public boolean solution(boolean isVIP, int price) {
    // TODO: VIP이거나(OR) 금액이 30000 이상이면 true
    if (isVIP || price >= 30000) {
      return true;
    }

    return false;
  }
}
