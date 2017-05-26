package com.andy.aspect;

import com.andy.annotation.MethodTimer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *方法计时器切面
 */
@Aspect
@Component
public class TimerAspect {

    private  static final Logger logger = LoggerFactory.getLogger("TimerAspect");

    /** 记录方法耗时
     * @param pjp
     * @param timer
     * @return
     */
    @Around(value = "@annotation(timer)")
    public Object recordTime(ProceedingJoinPoint pjp, MethodTimer timer) throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String className = target.getClass().getName();
        String methodName = currentMethod.getName();

        Date beginTime = new Date();
        logger.info("-------"+className+"."+methodName+"开始执行,beginTime:"+sdf.format(beginTime)+"-------");

        Object ret = pjp.proceed(); //控制权交给方法

        Date endTime = new Date();
        Long consumeTime = endTime.getTime() - beginTime.getTime();
        logger.info("-------"+className+"."+methodName+"执行完毕,endTime:"+sdf.format(endTime)+",共耗时:"+consumeTime+"毫秒-------");

        return ret;
    }
}
