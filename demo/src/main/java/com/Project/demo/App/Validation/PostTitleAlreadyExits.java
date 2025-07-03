package com.Project.demo.App.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostTitleValidation.class)
public @interface PostTitleAlreadyExits {

    String message() default "{TitleAlreadyExits}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}