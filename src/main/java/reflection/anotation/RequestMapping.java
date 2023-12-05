package reflection.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // 해당 어노테이션은 클리스 및 메서드에 붙일수 있음.
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";

    RequestMethod[] method() default {};
}
