package actors;

import akka.actor.*;
import akka.japi.*;
import actors.HelloActorProtocol.*;

public class Actor1 extends AbstractActor {

  public static Props getProps() {
    return Props.create(Actor1.class);
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(
            Compute.class,
            perform -> {
              try {
                sender().tell(perform.sum_function(), self());
              }catch(Exception ex) {
                throw ex;
              }
            })
        .build();
  }
}