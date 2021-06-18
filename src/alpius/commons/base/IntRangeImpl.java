package alpius.commons.base;

import jp.gr.java_conf.alpius.commons.annotations.Internal;
import jp.gr.java_conf.alpius.commons.base.Validate;
import jp.gr.java_conf.alpius.commons.base.IntRange;

import java.util.function.IntConsumer;

@Internal
public class IntRangeImpl implements IntRange {
    private final int start;
    private final int end;
    private final int by;
    private final boolean includeStart;
    private final boolean includeEnd;

    public IntRangeImpl(int start, int end, int by, boolean includeStart, boolean includeEnd) {
        if (includeStart) {
            if (includeEnd) {
                Validate.require(start <= end);
                Validate.require((end - start) % by == 0);
            } else {
                Validate.require(start < end);
                Validate.require((end - start - 1) % by == 0);
            }
        } else {
            if (includeEnd) {
                Validate.require(start + 1 <= end);
                Validate.require((end - start - 1) % by == 0);
            } else {
                Validate.require((start + 1) < end);
                Validate.require((end - start - 2) % by == 0);
            }
        }
        this.start = start;
        this.end = end;
        this.by = by;
        this.includeStart = includeStart;
        this.includeEnd = includeEnd;
    }


    @Override
    public void forEach(IntConsumer consumer) {
        int value = getMin();
        final int end = getMax();
        final int by = this.by;
        while (value <= end) {
            consumer.accept(value);
            value += by;
        }
    }

    @Override
    public void forEachReverse(IntConsumer consumer) {
        int value = getMax();
        final int end = getMin();
        final int by = this.by;
        while (value >= end) {
            consumer.accept(value);
            value += by;
        }
    }

    @Override
    public int getMin() {
        if (includeStart) {
            return start;
        } else {
            return start + 1;
        }
    }

    @Override
    public int getMax() {
        if (includeEnd) {
            return end;
        } else {
            return end - 1;
        }
    }

    @Override
    public int getBy() {
        return by;
    }

    @Override
    public boolean contains(int value) {
        return getMin() <= value && value <= getMax();
    }

    @Override
    public int clamp(int value) {
        if (value < getMin()) {
            return getMin();
        } else if (getMax() < value) {
            return getMax();
        } else {
            return value;
        }
    }
}
