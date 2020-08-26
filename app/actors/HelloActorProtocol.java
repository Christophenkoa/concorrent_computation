package actors;

public class HelloActorProtocol {

  public static class Compute {

    public long sum;

    public Compute() {sum=0;}

    public long sum_function () {
        this.sum = 0L;
        for(int i=0; i<=200000; i++) {
            sum = sum + i;
        }

      return sum;
    }

    public long sum_function2 () {
      this.sum = 0L;
      for(int i=200001; i<=400000; i++) {
          sum = sum + i;
        }

      return sum;
    }

    public long sum_function3 () {
      this.sum = 0L;
      for(int i=400001; i<=600000; i++) {
          sum = sum + i;
        }

      return sum;
    }

    public long sum_function4 () {
      this.sum = 0L;
      for(int i=600001; i<=800000; i++) {
          sum = sum + i;
        }

      return sum;
    }

    public long sum_function5 () {
      this.sum = 0L;
      for(int i=800001; i<=1000000; i++) {
          sum = sum + i;
        }

      return sum;
    }

  }
}