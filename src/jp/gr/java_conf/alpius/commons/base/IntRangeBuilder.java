package jp.gr.java_conf.alpius.commons.base;

public interface IntRangeBuilder {
    default IntRangeBuilder from(int from) {
        return from(from, true);
    }
    IntRangeBuilder from(int from, boolean inclusive);
    default IntRangeBuilder to(int to) {
        return to(to, true);
    }
    IntRangeBuilder to(int to, boolean inclusive);
    IntRangeBuilder by(int by);
    IntRange build();
}
