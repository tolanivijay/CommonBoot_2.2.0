package com.vijay.controller;

import com.vijay.components.WiredComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JunitController {
    
    @Autowired
    private WiredComponent component;
    
    @GetMapping("/gt")
    public String getComponent(@RequestParam("val") String val) throws Exception{
        return component.getValue(val);
    }
    
}
