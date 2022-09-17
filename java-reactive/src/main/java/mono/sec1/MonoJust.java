package mono.sec1;

import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i -> System.out.println(i + " Received!"));
    }
}
