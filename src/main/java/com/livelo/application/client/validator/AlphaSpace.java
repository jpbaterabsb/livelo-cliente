package com.livelo.application.client.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AlphaSpaceConstraintValidator.class)
public @interface AlphaSpace {

  String message() default "invalid text format";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String serviceQualifier() default "";
}

