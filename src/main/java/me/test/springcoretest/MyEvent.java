package me.test.springcoretest;

public class MyEvent {
    Object src;
    int data;

    public MyEvent(Object src,int data){
        this.src=src;
        this.data=data;
    }

    public void startEvent(){
        System.out.println(src+"|"+data);
    }
}
