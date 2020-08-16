package actors;

public class HelloActorProtocol {

  public static class SayHello {
    public final String name;

    public SayHello(String name) {
      this.name = name;
    }

    //test
    public long sum () {
        long sum = 0L;
        for(int i=0; i<200000; i++) {
            sum = sum + i;
        }

        return sum;
    }
  }
}