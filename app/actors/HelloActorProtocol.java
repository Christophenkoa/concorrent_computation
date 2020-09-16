package actors;

public class HelloActorProtocol {

  public static class Compute {

    public long startCount;
    public long endCount;

    public Compute(long startCount, long endCount) {
      this.startCount = startCount;
      this.endCount = endCount;
    }

    public long sum_function () {
        long sum = 0L;
        for(long i=startCount; i<=endCount; i++) {
            sum = sum + i;
        }

      return sum;
    }
  }
}