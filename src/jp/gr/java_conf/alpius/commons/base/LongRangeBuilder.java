package jp.gr.java_conf.alpius.commons.base;

public interface LongRangeBuilder {
    LongRangeBuilder from(long from, boolean inclusive);
    default LongRangeBuilder from(long from) {
        return from(from, true);
    }
    LongRangeBuilder to(long to, boolean inclusive);
    default LongRangeBuilder to(long to) {
        return to(to, true);
    }
    LongRangeBuilder by(long by);
    LongRange build();
}
