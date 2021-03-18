package me.test.springcoretest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));

        System.out.println("single");
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        //아래와 같이 호출할때 Singleton scope의 클래스에서 prototype scope의 인스턴스를 사용하고있을때에는, Scope의 proxymode옵션을 조정하지않으면(proxyMode=ScopedProxyMode.TARGET_CLASS), prototype으로 설정해놓은것은 항상 동일한 객체이다..
        //기본값은 별도의 Proxy로 감싸자않는데, Proxy로 감싸서 특정 작업을 해주어야 Singleton 상태의 클래스에서 Proxy instance를 참조할때 Proto 스콥의 인스턴스를 새로운 객체로 만들수있다
        // "proxyMode=ScopedProxyMode.TARGET_CLASS" 를 사용하면, 해당 객체는 프록시로 감싸진 상태가되어, 프록시로 감싼 객체(ProxyBean)를 호출하는것이다!
        System.out.println("proto by single");
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());

        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }
}
