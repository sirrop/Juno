package jp.gr.java_conf.alpius.commons.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

public class LongRangeTest {
    @Test
    public void test() {
        LongRange range = LongRange.builder()
                .from(0)
                .to(100)
                .by(2)
                .build();
        Assertions.assertEquals(0, range.getMin());
        Assertions.assertEquals(100, range.getMax());
        Assertions.assertEquals(2, range.getBy());
        Assertions.assertEquals(0, range.clamp(-1));
        Assertions.assertEquals(100, range.clamp(1000));
        AtomicLong count = new AtomicLong();
        range.forEach(value -> {
            Assertions.assertEquals(count.get(), value);
            count.addAndGet(2);
        });
    }

    @Test
    public void testExclusive() {
        LongRange range = LongRange.builder()
                .from(0, false)
                .to(100, false)
                .by(2)
                .build();
        Assertions.assertEquals(1, range.getMin());
        Assertions.assertEquals(99, range.getMax());
        Assertions.assertEquals(2, range.getBy());
        Assertions.assertEquals(1, range.clamp(-1));
        Assertions.assertEquals(99, range.clamp(10000));
        AtomicLong count = new AtomicLong(1);
        range.forEach(value -> {
            Assertions.assertEquals(count.get(), value);
            count.addAndGet(2);
        });
    }
}
