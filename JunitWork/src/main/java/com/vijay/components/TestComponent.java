package com.vijay.components;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TestComponent {

    public String throwsExceptionOnStringLength(String exception) throws TestException{
        if (StringUtils.isEmpty(exception) || exception.length() > 3){
            throw new TestException();
        }
        return exception;
    }
}
