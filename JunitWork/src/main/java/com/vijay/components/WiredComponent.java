package com.vijay.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WiredComponent {

    @Autowired
    private TestComponent component;

    public String getValue(String val) throws Exception{
        return component.throwsExceptionOnStringLength(val);
    }
}
