package me.test.springcoretest;

import me.test.springcoretest.aop.AopTest;
import me.test.springcoretest.pack.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext ctx;

    @Value("${app.name}")
    String name;

    @Value("${app.name2}")
    String name2;

    @Value("${app.name3}")
    String name3;

    @Value("${app.name4}")
    String name4;

    @Value("${app.name5}")
    String name5;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    ResourcePatternResolver resourcePatternResolver;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    ConversionService conversionService;

    @Value("#{1+1}")
    int value;

    @Value("#{1 == 1}")
    boolean trueOfFalse;

    @Value("#{new String('abc').toUpperCase()}")
    String abc;

    @Value("#{sample.i}")
    int sampleData;

    @Autowired
    AopTest aopTest;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Resource resource=resourceLoader.getResource("classpath:/");
//        Resource fileResource=resourceLoader.getResource("file:/");
//        System.out.println(resource.getFile().getName());
//        System.out.println(fileResource.getFile().getName());
//
//        System.out.println("proto");
//        System.out.println(ctx.getBean(Proto.class));
//        System.out.println(ctx.getBean(Proto.class));
//        System.out.println(ctx.getBean(Proto.class));
//
        System.out.println("single");
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        //????????? ?????? ???????????? Singleton scope??? ??????????????? prototype scope??? ??????????????? ???????????????????????????, Scope??? proxymode????????? ?????????????????????(proxyMode=ScopedProxyMode.TARGET_CLASS), prototype?????? ????????????????????? ?????? ????????? ????????????..
        //???????????? ????????? Proxy??? ??????????????????, Proxy??? ????????? ?????? ????????? ???????????? Singleton ????????? ??????????????? Proxy instance??? ???????????? Proto ????????? ??????????????? ????????? ????????? ???????????????
        // "proxyMode=ScopedProxyMode.TARGET_CLASS" ??? ????????????, ?????? ????????? ???????????? ????????? ???????????????, ???????????? ?????? ??????(ProxyBean)??? ?????????????????????!
        System.out.println("proto by single");
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
//
//        System.out.println(name);
//        System.out.println(name2);
//        System.out.println(name3);
//        System.out.println(name4);
//
//
//        applicationEventPublisher.publishEvent(new MyEvent(this,100));
//
//        ((ConfigurableApplicationContext)ctx).start();
//        ((ConfigurableApplicationContext)ctx).stop();
//        ((ConfigurableApplicationContext)ctx).close();

        System.out.println(conversionService);
//
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(LocalDateTime.now());
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
//        System.out.println(conversionService.getClass().toString());

//        System.out.println(abc);
//        System.out.println(sampleData);
//
//        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
//        Expression expression=spelExpressionParser.parseExpression("100+2");
//        Integer result=expression.getValue(Integer.class);
//        System.out.println(result);

        aopTest.method1();
        aopTest.method2("abc");
    }
}
