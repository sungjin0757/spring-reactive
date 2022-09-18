package mono.sec1;

import mono.common.constants.CommonLog;
import mono.common.constants.FakerConstants;
import mono.common.util.SimpleMonoUtil;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static mono.common.constants.CommonLog.*;


public class AsyncExample {

    private static Mono<String> getMono() {
        log.info("====== ENTERED ======");
        return Mono.fromSupplier(() -> {
            log.info("====== GENERATING ======");
            SimpleMonoUtil.sleepSeconds(3);
            return FakerConstants.FAKER.name().fullName();
        });
    }

    public static void main(String[] args) throws InterruptedException {
        getMono();
        getMono()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(SimpleMonoUtil.onNext());
        getMono();
    }
}
