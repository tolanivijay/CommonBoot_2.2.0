package com.vijay.controller;

import com.vijay.components.TestComponent;
import com.vijay.components.TestException;
import com.vijay.components.WiredComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {JunitController.class})
class JunitControllerTest {

    @Autowired
    JunitController controller;

    @SpyBean
    WiredComponent wired;

    @SpyBean
    TestComponent testComponent;

    @Test
    public void contextAvailable(){
        assertNotNull(controller);
    }

    @Test
    public void testIfExceptionThrown() throws Exception{
        assertThrows(TestException.class,() -> {
            controller.getComponent("abcd");
        });
    }

}