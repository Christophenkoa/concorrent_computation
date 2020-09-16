package controllers;

import akka.actor.*;
import actors.*;
import actors.HelloActorProtocol.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

import static akka.pattern.Patterns.ask;


@Singleton
public class Application extends Controller {

  final ActorRef actor1, actor2, actor3, actor4, actor5;

  String [] sum = {"0","0","0","0","0"};


  @Inject
  public Application(ActorSystem system) {
    actor1 = system.actorOf(AkkaActor.getProps());
    actor2 = system.actorOf(AkkaActor.getProps());
    actor3 = system.actorOf(AkkaActor.getProps());
    actor4 = system.actorOf(AkkaActor.getProps());
    actor5 = system.actorOf(AkkaActor.getProps());
  }

    public Result main() {

      FutureConverters.toJava(ask(actor1, new Compute(0,200000), 1000))
        .thenApply(response -> ok(sum[0] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor2, new Compute(200001, 400000), 1000))
        .thenApply(response -> ok(sum[1] =  String.valueOf(response)));
      
      FutureConverters.toJava(ask(actor3, new Compute(400001,600000), 1000))
        .thenApply(response -> ok(sum[2] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor4, new Compute(600001,800000), 1000))
        .thenApply(response -> ok(sum[3] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor5, new Compute(800001,1000000), 1000))
        .thenApply(response -> ok(sum[4] =  String.valueOf(response)));

      long total = 0L;

      for(int i=0;i<5;i++) {
        long temp = Long.parseLong(sum[i]);
        total += temp;   
      }
      
    return ok(views.html.actors.render(total));
  }


//test function
  // public Result index(){
  //   long var = 0L;
  //   for(int i=0; i<=1000000;i++) {
  //     var += i; 
  //   }
  //   return ok(var + "");
  // }

  //   result = toto.toCompletableFuture().get();

}