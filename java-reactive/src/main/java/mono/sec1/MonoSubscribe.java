package mono.sec1;

import mono.common.util.SimpleMonoUtil;
import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("text")
                                .map(String::length)
                                .map(l -> l / 0);

        // Not Operating
//        mono.subscribe();

        mono.subscribe(
                t -> System.out.println(t), // Subscriber
                throwable -> System.out.println(throwable.getMessage()), // Error Message
                () -> System.out.println("Completed") // Complete Message
                );

        // Util Class Uses
        mono.subscribe(
                SimpleMonoUtil.onNext(), // Subscriber
                SimpleMonoUtil.onError(), // Error Message
                SimpleMonoUtil.onComplete() // Complete Message
        );
    }

}
