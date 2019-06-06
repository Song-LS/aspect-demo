package com.sls.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Aspect // 表明是一个切面类
@Component // 将当前类注入到Spring 容器内
public class LogAspect {

    // 切入点， 其中execution 用于使用切面的连接点
    // 用方法：execution(方法修饰符(可选) 返回类型 方法名 参数 异常模式(可选)) ，可以使用通配符匹配字符，*可以匹配任意字符。
    @Pointcut("execution(public * com.sls.controller.*.*(..))")
    public void aspect(){}

    // 在方法前执行
    @Before("aspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore");
    }

    // 在方法后执行
    @After("aspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    // 在方法执行后返回一个结果后执行
    @AfterReturning("aspect()")
    public void doAfterReturuning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning");
    }

    // 在方法执行过程中抛出异常执行
    @AfterThrowing("aspect()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        System.out.println("doAfterThrowing");
    }

    // 环绕通知，就是可以在执行前后都使用， 这个方法参数必须为ProceedingJoinPoint
    // proceed()方法就是被切面的方法，上面四个方法可以使用JoinPoint，JoinPoint包含了类名，被切面的方法名，参数等信息。
    @Around("aspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("deAround");
        return joinPoint.proceed();
    }

}
