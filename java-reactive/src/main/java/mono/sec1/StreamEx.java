package mono.sec1;

import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3)
                .map(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s * 2;
                });

        stream.forEach(System.out::println);
    }
}
