package com.andy.quartz;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
@Component("jobDetailBean")
public class JobDetailBean extends QuartzJobBean {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger("JobDetailBean");

	private String targetObject;
	private String targetMethod;
	@Autowired
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			Object bean = ctx.getBean(targetObject);
			Method m = bean.getClass().getMethod(targetMethod);
			m.invoke(bean, null);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.ctx = applicationContext;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public String getTargetObject() {
		return targetObject;
	}

	public String getTargetMethod() {
		return targetMethod;
	}
}