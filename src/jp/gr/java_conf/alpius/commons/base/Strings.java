package jp.gr.java_conf.alpius.commons.base;

public final class Strings {
    private Strings() {}

    public static String emptyToNull(String string) {
        if (isNullOrEmpty(string)) {
            return null;
        } else {
            return string;
        }
    }

    public static String nullToEmpty(String string) {
        if (isNullOrEmpty(string)) {
            return "";
        } else {
            return string;
        }
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String string) {
        return !isNullOrEmpty(string);
    }
}
