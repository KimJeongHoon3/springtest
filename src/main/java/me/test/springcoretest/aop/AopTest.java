package me.test.springcoretest.aop;

import org.springframework.stereotype.Component;

@Component
public class AopTest {

    @PerfLogging
    public void method1(){
        System.out.println("method1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2(String str){
        System.out.println("method2 start");
    }

    private void method3(){
        System.out.println("method2 start");
    }
}
