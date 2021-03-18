package me.test.springcoretest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestService2 {
    Logger log= LoggerFactory.getLogger(TestService2.class);
    @PostConstruct
    public void setup(){
        log.info("TestService2 postConstruct");
    }
}
