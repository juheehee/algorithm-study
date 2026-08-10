public class ParkingFee {
  public int solution(int minutes) {
    int basicTime = 60;
    int basicFee = 0;
    int extraTime = 30;
    int extraFee = 1000;

    if (minutes <= basicTime) {
      return basicFee;
    }
    int currentTime = minutes - basicTime;
    int extraBlocks = (currentTime + extraTime - 1) / extraTime;
    return basicFee + (extraBlocks * extraFee);
  }
  public int solution(int minutes) {
    if (minutes <= 60) {
      return 0;
    }
    int extraMinutes = minutes - 60;
    int units = (extraMinutes + 29) /  30;
    int fee = units * 1000;
    
    if (fee > 10000) {
      fee = 10000;
    }
    return fee;
  }
}
