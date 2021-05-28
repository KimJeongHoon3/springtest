package me.test.springcoretest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //@Around("execution(* me.test.)")
//    @Around("@annotation(PerfLogging)") //애노테이션 기반으로 AOP적용
//    @Around("bean(aopTest)") //등록된 bean에도 적용가능
//    @Around("pointCut()") //@pointcut 사용
    @Around("execution(public void me.test.springcoretest.aop..*(..)))")
    public Object logPref(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin=System.currentTimeMillis(); //메소드 호출 이전
        Object retVal=proceedingJoinPoint.proceed();
        System.out.println(System.currentTimeMillis()-begin); //메소드 호출 이후
        return retVal;
    }

//    @Pointcut("within(me.test.springcoretest.aop..*)")
    @Pointcut("@annotation(PerfLogging)")
    public void pointCut(){}
}
