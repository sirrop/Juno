package jp.gr.java_conf.alpius.commons.base;

public class NotImplementedException extends UnsupportedOperationException {
    public NotImplementedException() {}

    public NotImplementedException(String mes) {
        super(mes);
    }

    public NotImplementedException(String mes, Throwable cause) {
        super(mes, cause);
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
    }
}
