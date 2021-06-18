package jp.gr.java_conf.alpius.commons.base;

public interface Pair<F, S> {
    F getFirst();
    S getSecond();

    static <F, S> Pair<F, S> of(F first, S second) {
        if (first == null && second == null) return empty();
        return new Pair<>() {
            @Override
            public F getFirst() {
                return first;
            }

            @Override
            public S getSecond() {
                return second;
            }
        };
    }

    static <F, S> Pair<F, S> empty() {
        return new Pair<>() {
            @Override
            public F getFirst() {
                return null;
            }

            @Override
            public S getSecond() {
                return null;
            }
        };
    }
}
