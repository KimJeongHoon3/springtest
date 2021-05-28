package me.test.springcoretest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    @EventListener
    public void handleMyEvent(MyEvent myEvent){
        System.out.println("handleMyEvent");
        myEvent.startEvent();
    }

    @EventListener
    public void handleStartEvent(ContextStartedEvent contextStartedEvent){
        System.out.println("handleStartEvent | "+contextStartedEvent.getSource());
    }

    @EventListener
    public void handleCloseEvent(ContextClosedEvent contextClosedEvent){
        System.out.println("handleCloseEvent | "+contextClosedEvent.getSource());
//        ApplicationContext applicationContext = contextClosedEvent.getApplicationContext();
//        Object proto = applicationContext.getBean("proto");
//        if(proto instanceof Proto){
//            System.out.println(((Proto) proto).toString());
//        }
    }


}
