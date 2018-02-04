package jp.co.future.uroborosql.mapping.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * エンティティ 永続化除外対象指定アノテーション
 *
 * @author ota
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transient {
	/** insert文で除外対象とするかどうか */
	boolean insert() default true;

	/** update文で除外対象とするかどうか */
	boolean update() default true;
}