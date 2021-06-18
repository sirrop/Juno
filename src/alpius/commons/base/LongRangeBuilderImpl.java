package alpius.commons.base;

import jp.gr.java_conf.alpius.commons.base.LongRange;
import jp.gr.java_conf.alpius.commons.base.LongRangeBuilder;
import jp.gr.java_conf.alpius.commons.base.Validate;

public class LongRangeBuilderImpl implements LongRangeBuilder {
    private boolean initializedFrom = false;
    private long from;
    private boolean includeFrom;

    private boolean initializedTo = false;
    private long to;
    private boolean includeTo;

    private long by = 1;

    @Override
    public LongRangeBuilder from(long from, boolean inclusive) {
        this.from = from;
        this.includeFrom = inclusive;
        initializedFrom = true;
        return this;
    }

    @Override
    public LongRangeBuilder to(long to, boolean inclusive) {
        this.to = to;
        this.includeTo = inclusive;
        initializedTo = true;
        return this;
    }

    @Override
    public LongRangeBuilder by(long by) {
        this.by = by;
        return this;
    }

    @Override
    public LongRange build() {
        Validate.check(initializedFrom && initializedTo);
        return new LongRangeImpl(from, to, by, includeFrom, includeTo);
    }
}
