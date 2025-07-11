package com.Project.demo.App.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SpringBlogException.class)
    public String servletRequestBindingException(ServletRequestBindingException ex){
        log.error("SpringBlogException has ocurred: " + ex.getMessage());
        return "error";
    }

}
