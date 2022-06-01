package dev.ranieri.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Annotation can be read during runtime
@Target(ElementType.FIELD) // Annotation is allowed only on a field
public @interface MathConstant {
}
