package jp.gr.java_conf.alpius.commons.base;

import alpius.commons.base.LongRangeBuilderImpl;

import java.util.function.LongConsumer;

public interface LongRange {
    void forEach(LongConsumer consumer);
    void forEachReverse(LongConsumer consumer);
    long getMin();
    long getMax();
    long getBy();
    boolean contains(long value);
    long clamp(long value);

    static LongRangeBuilder builder() {
        return new LongRangeBuilderImpl();
    }
}
