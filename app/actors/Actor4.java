package actors;

import akka.actor.*;
import akka.japi.*;
import actors.HelloActorProtocol.*;

public class Actor4 extends AbstractActor {

  public static Props getProps() {
    return Props.create(Actor4.class);
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(
            Compute.class,
            perform -> {
              try {
                sender().tell(perform.sum_function4(), self());
              }catch(Exception ex) {
                throw ex;
              }
            })
        .build();
  }
}