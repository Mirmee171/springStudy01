package com.test.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Singleton01Test {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 생성")
    void singletonContainer() {
        Singleton01 singletonService1 = Singleton01.getInstance();
        Singleton01 singletonService2 = Singleton01.getInstance();
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

}