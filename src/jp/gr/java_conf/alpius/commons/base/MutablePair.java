package jp.gr.java_conf.alpius.commons.base;

public interface MutablePair<F, S> extends Pair<F, S> {
    void setFirst(F first);
    void setSecond(S second);

    static <F, S> MutablePair<F, S> of(F first, S second) {
        return new MutablePair<>() {
            private F f = first;
            private S s = second;

            @Override
            public void setFirst(F first) {
                f = first;
            }

            @Override
            public void setSecond(S second) {
                s = second;
            }

            @Override
            public F getFirst() {
                return f;
            }

            @Override
            public S getSecond() {
                return s;
            }
        };
    }

    static <F, S> MutablePair<F, S> empty() {
        return of(null, null);
    }
}
