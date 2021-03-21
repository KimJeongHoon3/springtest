package me.test.springcoretest;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    @EventListener
    public void handleMyEvent(MyEvent myEvent){
        System.out.println("handleMyEvent");
        myEvent.startEvent();
    }
}
