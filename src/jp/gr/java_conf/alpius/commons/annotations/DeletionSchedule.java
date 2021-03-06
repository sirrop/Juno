package jp.gr.java_conf.alpius.commons.annotations;

import java.lang.annotation.*;

/**
 * そのAPIが将来削除されることを示します。
 * <p>
 *     文字列を指定することで、削除する予定のバージョンを明示できます。
 * </p>
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
public @interface DeletionSchedule {
    String value() default "";
}
