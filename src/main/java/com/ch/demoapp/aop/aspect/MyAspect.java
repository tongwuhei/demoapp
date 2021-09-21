package com.ch.demoapp.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chj
 * @date 2021/6/8 19:52
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.ch.demoapp.aop.api.*.*(..))")
    public void pintCut(){}

    /**
     * 前置通知:方法执行前拦截到
     * @param point
     */
    @Before("pintCut()")
    public void before(JoinPoint point){
        String methodName = point.getSignature().getName();
        Object [] params = point.getArgs();
        List< Object> list = new ArrayList<Object>(params.length);
        Collections.addAll(list,params);
        System.out.println("前置通知--方法名："+methodName+"，参数："+list);
    }

    /**
     * 环绕通知
     * @param point
     */
    //@Around(value = "execution(public * com.springboot.controller.UserController.*(..))")
     @Around("pintCut()")
    public void around(JoinPoint point){
        System.out.println("环绕通知s");
    }

    /**
     * 后置通知：当目标方法执行完之后，不管抛不抛异常都会走此方法
     * @param point
     */
    //@After(value = "execution(public * com.springboot.controller.UserController.*(..))")
    @After("pintCut()")
    public void after(JoinPoint point){
        System.out.println("后置通知");

    }

    /**
     * 返回通知：当方法正常执行通过之后执行
     * @param point
     * @param result 返回值
     */
    //@AfterReturning(value="execution(public * com.springboot.controller.UserController.*(..))",returning="result")
    @AfterReturning(returning = "result",pointcut = "pintCut()")
    public void afterReturning(JoinPoint point, Object result){
        System.out.println("返回通知"+",返回结果："+result);

    }

    /**
     * 异常通知：当目标方法非正常执行完成、发生异常、抛出异常的时候会走此方法
     */
    //@AfterThrowing(value="execution(public * com.springboot.controller.UserController.*(..))",throwing="e")
    @AfterThrowing(pointcut = "pintCut()",throwing="e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        System.out.println("异常通知,"+"异常信息："+e);
    }

}
