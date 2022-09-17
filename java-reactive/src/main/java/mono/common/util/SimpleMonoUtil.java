package mono.common.util;


import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import static mono.common.constants.CommonLog.*;

public class SimpleMonoUtil {
    public static Consumer<Object> onNext() {
        return o -> log.info(o + " Received!");
    }

    public static Consumer<Throwable> onError() {
        return err -> log.info(err.getMessage());
    }

    public static Runnable onComplete() {
        return () -> log.info("Completed!");
    }

    public static void execute(Mono<?> mono) {
        mono.subscribe(
                onNext(),
                onError(),
                onComplete()
        );
    }

    public static void sleepSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            log.severe(e.getMessage());
        }
    }
}
