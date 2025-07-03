package com.Project.demo.App.Validation;

import ch.qos.logback.core.util.StringUtil;
import com.Project.demo.App.Service.PostService;
import com.Project.demo.App.domain.Post;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public record PostTitleValidation(PostService postService) implements ConstraintValidator<
        PostTitleAlreadyExits, Post> {

    @Override
    public void initialize(PostTitleAlreadyExits constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext){

        if(!StringUtil.isNullOrEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{TitleAlreadyExits}")
                    .addPropertyNode("title").addConstraintViolation();
            return false;
        }

        return true;

    }

}
