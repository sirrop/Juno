package alpius.commons.base;

import jp.gr.java_conf.alpius.commons.base.IntRange;
import jp.gr.java_conf.alpius.commons.base.IntRangeBuilder;
import jp.gr.java_conf.alpius.commons.base.Validate;

public class IntRangeBuilderImpl implements IntRangeBuilder {
    private boolean initializedFrom = false;
    private int from;
    private boolean includeFrom;

    private boolean initializedTo = false;
    private int to;
    private boolean includeTo;

    private int by = 1;

    @Override
    public IntRangeBuilder from(int from, boolean inclusive) {
        this.from = from;
        this.includeFrom = inclusive;
        initializedFrom = true;
        return this;
    }

    @Override
    public IntRangeBuilder to(int to, boolean inclusive) {
        this.to = to;
        this.includeTo = inclusive;
        initializedTo = true;
        return this;
    }

    @Override
    public IntRangeBuilder by(int by) {
        this.by = by;
        return this;
    }

    @Override
    public IntRange build() {
        Validate.check(initializedFrom && initializedTo);
        return new IntRangeImpl(from, to, by, includeFrom, includeTo);
    }
}
