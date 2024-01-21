package com.test.AOPAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Autowired
    DemoAction demoAction;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        demoAction.biz();
//        demoAction.getSayHello();
//        demoAction.accessArray();
        demoAction.printMessage("Hello World");
    }

}
