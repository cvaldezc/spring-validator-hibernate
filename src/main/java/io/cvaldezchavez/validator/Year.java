package io.cvaldezchavez.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = YearConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Year {
	
	int value();
	
	String message() default "El año debe ser 1989";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
