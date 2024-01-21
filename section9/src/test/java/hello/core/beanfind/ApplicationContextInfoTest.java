package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] allBeans = ac.getBeanDefinitionNames();
        for (String allBean : allBeans) {
            Object bean = ac.getBean(allBean);
            System.out.println("name = " + allBean + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] allBeans = ac.getBeanDefinitionNames();
        for (String allBean : allBeans) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(allBean);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(allBean);
                System.out.println("name = " + allBean + " object = " + bean);
            }
        }
    }
}
