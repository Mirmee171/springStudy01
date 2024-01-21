package com.test.AOPAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//@Aspect어노테이션을 사용하여 Aspect class임을 선언한다.
@Component
public class CommonAspect {

    @Pointcut("execution(* biz())")
    /*
    Pointcut은 Advice의 실행 위치(Join point)를 나타낸다.
    즉 실행 시킬 클래스의 메소드를 지정한다.
    @Around를 @Pointcut으로 다음과 같이 사용할 수 있다.
     */
    public void accessAllBiz(){}

    @Pointcut("execution(* foo())")
    public void accessAllfoo(){}

    @Around("accessAllBiz() || accessAllfoo()")
    /*
    @Around 어노테이션은 ProceedingJoinPoint를 인자로 갖는다.
    해당 클래스는 PointCut대상 오브젝트(Method)를 실행할 수 있다.
    @Around를 사용하여 함수 실행 전, 후 시점에 로그를 출력했다.
    */
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before "+proceedingJoinPoint.getSignature().toShortString());
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After "+proceedingJoinPoint.getSignature().toShortString());
    }

    @Before("execution(* com.test.AOPAnnotation.DemoAction.biz())")
    //Jointpoint가 실행되기 전 실행된다. ( Advice에서 Jointpoint실행을 제어할 수 없다. )
    public void checkSomethingBefore() {
        System.out.println("Check something before...");
    }

    @AfterReturning(
            pointcut ="execution(* com.test.AOPAnnotation.DemoAction.get*(..))",
            returning="retVal")
    //Jointpoint 실행후 리턴된 데이터를 받을 수 있다. ( Joinpoint에서 예외 발생시 실행되지 않는다. )
    public void checkReturnValue(Object retVal) {
        if(retVal instanceof String) {
            System.out.println("the return value is "+(String)retVal);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.test.AOPAnnotation.DemoAction.*(..))",
            throwing = "ex")
    //Joinpoint에서 예외 발생 시 실행된다.
    public void handleThrowExceptionOnAll(Exception ex) {
        System.out.println("handleThrowExceptionOnAll");
        ex.printStackTrace();
    }

    @After("execution(* com.test.AOPAnnotation.DemoAction.get*(..))")
    //Jointpoint가 호출되고 무조건 실행된다.
    public void finallyCheckReturnValue(){
        System.out.println("check something one more");
    }

    @Before(
            "execution(* com.test.AOPAnnotation.DemoAction.printMessage(..)) && " +
                    "args(msg)")
    public void checkParameterBefore(String msg){
        System.out.println("checkParameterBefore >> " + msg);
    }


}
