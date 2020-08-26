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
    actor1 = system.actorOf(Actor1.getProps());
    actor2 = system.actorOf(Actor2.getProps());
    actor3 = system.actorOf(Actor3.getProps());
    actor4 = system.actorOf(Actor4.getProps());
    actor5 = system.actorOf(Actor5.getProps());
  }

    public Result main() {

      FutureConverters.toJava(ask(actor1, new Compute(), 100000))
        .thenApply(response -> ok(sum[0] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor2, new Compute(), 100000))
        .thenApply(response -> ok(sum[1] =  String.valueOf(response)));
      
      FutureConverters.toJava(ask(actor3, new Compute(), 100000))
        .thenApply(response -> ok(sum[2] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor4, new Compute(), 100000))
        .thenApply(response -> ok(sum[3] =  String.valueOf(response)));

      FutureConverters.toJava(ask(actor5, new Compute(), 100000))
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