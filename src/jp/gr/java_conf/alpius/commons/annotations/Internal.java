package jp.gr.java_conf.alpius.commons.annotations;

import java.lang.annotation.*;

/**
 * Public APIではない要素につけられます。
 * <p>
 *     様々な理由からpublicになっていますが、内部で使用するためのAPIに付与されます。
 *     このアノテーションがつけられたAPIにサードパーティは依存してはいけません。
 *     バージョンの変更などにより突然動作しなくなる可能性があります。
 * </p>
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
public @interface Internal {
}
