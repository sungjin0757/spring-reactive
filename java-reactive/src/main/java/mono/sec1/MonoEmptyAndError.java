package mono.sec1;

import mono.common.constants.FakerConstants;
import mono.common.util.SimpleMonoUtil;
import reactor.core.publisher.Mono;

public class MonoEmptyAndError {
    private static Mono<String> testRepository(int id) {
        if(id == 0)
            return Mono.error(new RuntimeException("Not Validated Value!"));
        if(isOdd(id))
            return Mono.just(
                    FakerConstants.FAKER
                            .name()
                            .firstName()
            );
        return Mono.empty();
    }

    private static boolean isOdd(int val) {
        if(val % 2 == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        SimpleMonoUtil.execute(testRepository(1));
        SimpleMonoUtil.execute(testRepository(2));
        SimpleMonoUtil.execute(testRepository(0));
    }
}
