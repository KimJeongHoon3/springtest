package me.test.springcoretest;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ProviderCreatingFactoryBean;
import org.springframework.stereotype.Component;

import javax.inject.Provider;


@Component
public class Single {

    @Autowired
    Proto proto;
    public Proto getProto() {
        return proto;
    }

//    @Autowired
//    Provider<Proto> proto;
//
//    public Proto getProto() {
//
//        return proto.get();
//    }
}
