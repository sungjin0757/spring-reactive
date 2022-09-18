package mono.sec1;


import mono.common.constants.FakerConstants;
import mono.common.util.SimpleMonoUtil;
import reactor.core.publisher.Mono;

public class MonoWithSupplier {
    private static String getTestName() {
        return FakerConstants.FAKER
                .name()
                .fullName();
    }

    public static void main(String[] args) {
        // only when you have data already
        Mono<String> mono = Mono.just(getTestName());

        Mono<String> monoFromSupplier = Mono.fromSupplier(MonoWithSupplier::getTestName);

        SimpleMonoUtil.execute(monoFromSupplier);
    }
}
