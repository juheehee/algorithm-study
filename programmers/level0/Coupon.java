public class Coupon {
  public static void main(String[] args) {
    Coupon sol = new Coupon();

    System.out.println(sol.solution(true, 60000)); // true (VIP + 5만원 이상)
    System.out.println(sol.solution(true, 30000)); // false (VIP이지만 금액 부족)
    System.out.println(sol.solution(false, 60000)); // false (금액은 되지만 VIP 아님)
    System.out.println(sol.solution(false, 30000)); // false (둘 다 안 됨)
  }

  public boolean solution(boolean isVIP, int price) {
    // TODO: VIP이고(AND) 금액이 50000 이상이면 true
    if (isVIP && price >= 50000) {
      return true;
    }

    return false;
  }
}
