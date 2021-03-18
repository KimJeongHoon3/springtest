package me.test.springcoretest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestService implements InitializingBean, DisposableBean {
    Logger log= LoggerFactory.getLogger(TestService.class);


    TestService2 testService2;

    @PostConstruct
    public void setup(){
        log.info("TestService postConstruct");
//        AutowiredAnnotationBeanPostProcessor
    }

    @Autowired
    public void setTestService2(TestService2 testService2){
        this.testService2=testService2;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy");
    }
}
