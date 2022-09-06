package com.wonit.springbootplayground;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Retention(RetentionPolicy.RUNTIME) // 뭐야 이게?
@Target(ElementType.TYPE)
public @interface SomeAnnotation {
}
