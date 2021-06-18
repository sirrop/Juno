package jp.gr.java_conf.alpius.commons.base;

import alpius.commons.base.IntRangeBuilderImpl;

import java.util.function.IntConsumer;

public interface IntRange {
    void forEach(IntConsumer consumer);
    void forEachReverse(IntConsumer consumer);
    int getMin();
    int getMax();
    int getBy();
    boolean contains(int value);
    int clamp(int value);

    static IntRangeBuilder builder() {
        return new IntRangeBuilderImpl();
    }
}
