package com.andy.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.andy.annotation.IpPort;
import com.andy.util.IPAddressUtil;
@Aspect
@Component
public class IpPortAspect {
	
	@Around(value = "@annotation(ipPort)")
    public Object ipPort(ProceedingJoinPoint pjp, IpPort ipPort) throws Throwable {

        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        
        //获取当前注解的方法
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        
        //获取注解信息
        IpPort annotation = currentMethod.getAnnotation(IpPort.class);
        String ip = annotation.ip();
        String port = annotation.port();

        String localIp = IPAddressUtil.getIp();
        int tomcatPort = IPAddressUtil.getTomcatPort();
        
        Boolean allowInvoke = true;
        if(ip.equals(localIp)) {
        		if(port != null && !port.equals("")) {
        			if(!port.equals(tomcatPort + "")) allowInvoke = false;
        		}
        }
        else {
        		allowInvoke = false;
        }
        
        if(allowInvoke) {
        		Object ret = pjp.proceed(); //控制权交给方法
        		return ret;
        }
        
        return null;
        
    }
}
