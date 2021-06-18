package jp.gr.java_conf.alpius.commons.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({TYPE, ANNOTATION_TYPE, FIELD, METHOD, CONSTRUCTOR, PACKAGE})
public @interface VisibleForTesting {
}
