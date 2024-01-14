package com.test.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Singleton05Test {

    @Test
    @DisplayName("Enum을 통해 싱글톤 만들기")
    void enumDemo() {
        Singleton05 instance1 = Singleton05.INSTANCE;
        Singleton05 instance2 = Singleton05.INSTANCE;
        instance1.setValue(2);
        Assertions.assertThat(instance1).isSameAs(instance2);
        System.out.println("instance1 = " + instance1.getValue());
        System.out.println("instance2 = " + instance2.getValue());

    }

}