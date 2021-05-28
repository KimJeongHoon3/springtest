package me.test.springcoretest.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS) //컴파일해서 클래스 파일안에도(바이트코드) 해당 annotation이 남아있다는 말..(default) Source는 컴파일시 사라
public @interface PerfLogging {

}
