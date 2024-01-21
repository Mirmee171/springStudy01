package com.test.AOPAnnotation;

import org.springframework.stereotype.Component;

@Component
public class DemoAction {

    public void biz() {
        System.out.println("do logic");
    }

    public String getSayHello() {
        return "Hello World";
    }

    public void accessArray() {
        int[] s = {1,2,3};
        System.out.println(s[4]);
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

}
