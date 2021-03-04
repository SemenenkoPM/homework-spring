package ru.itsjava.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Conditional(OnCoffeeCondition.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionalOnCoffee {

}
