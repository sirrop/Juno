package alpius.commons.base;

import jp.gr.java_conf.alpius.commons.annotations.Internal;
import jp.gr.java_conf.alpius.commons.base.LongRange;
import jp.gr.java_conf.alpius.commons.base.Validate;

import java.util.function.LongConsumer;

@Internal
public class LongRangeImpl implements LongRange {
    private final long start;
    private final long end;

    @Override
    public long getBy() {
        return by;
    }

    private final long by;
    private final boolean includeStart;
    private final boolean includeEnd;

    public LongRangeImpl(long start, long end, long by, boolean includeStart, boolean includeEnd) {
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
    public void forEach(LongConsumer consumer) {
        long value = getMin();
        final long end = getMax();
        final long by = this.by;
        while (value <= end) {
            consumer.accept(value);
            value += by;
        }
    }

    @Override
    public void forEachReverse(LongConsumer consumer) {
        long value = getMax();
        final long end = getMin();
        final long by = this.by;
        while (value >= end) {
            consumer.accept(value);
            value += by;
        }
    }

    @Override
    public long getMin() {
        if (includeStart) {
            return start;
        } else {
            return start + 1;
        }
    }

    @Override
    public long getMax() {
        if (includeEnd) {
            return end;
        } else {
            return end - 1;
        }
    }

    @Override
    public boolean contains(long value) {
        return getMin() <= value && value <= getMax();
    }

    @Override
    public long clamp(long value) {
        if (value < getMin()) {
            return getMin();
        } else if (getMax() < value) {
            return getMax();
        } else {
            return value;
        }
    }
}
