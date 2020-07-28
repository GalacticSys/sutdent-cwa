package com.hjt.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppException {

    @ExceptionHandler(value = UnauthorizedException.class)
    public Map unauthorizedException(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","无权限");
        return map;
    }

}
