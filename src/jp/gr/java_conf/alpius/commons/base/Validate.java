package jp.gr.java_conf.alpius.commons.base;

public final class Validate {
    private Validate() {}

    private static final String EMPTY = "";

    public static void require(boolean value, String errMes) {
        if (!value) {
            throw new IllegalArgumentException(errMes);
        }
    }

    public static void require(boolean value) {
        require(value, EMPTY);
    }

    public static void check(boolean value, String errMes) {
        if (!value) {
            throw new IllegalStateException(errMes);
        }
    }

    public static void check(boolean value) {
        check(value, EMPTY);
    }
}
