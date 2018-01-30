master使用技术
1. spring 4.3.8.RELEASE+springmvc 4.3.8.RELEASE+mybatis 3.4.2
2. logback 1.1.7
3. mysql 5.1.30 + druid 1.0.18:http://127.0.0.1:8080/master/monitor/druid/datasource.html
4. shiro 1.2.3
5. spring-data-redis 2.0.0
6. swagger2 2.4.0:http://127.0.0.1:8080/master/swagger-ui.html

*注意问题：springMVC在action的跳转时，会自动加上你当前页面的根目录*


<h1>spring + quartz集群配置<h1>


1.创建quartz数据库:[tables_mysql.sql](https://github.com/AndyHooo/master/blob/master/tables_mysql.sql)  

2.添加jar包:
[pom.xml](https://github.com/AndyHooo/master/blob/master/pom.xml)   
 
3.添加quartz配置文件:[quartz.properties](https://github.com/AndyHooo/master/blob/master/src/main/resources/quartz.properties)  
4.添加代理类: [JobDetailBean.java](https://github.com/AndyHooo/master/blob/master/src/main/java/com/andy/quartz/JobDetailBean.java) 

``` java
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
```
5.配置定时文件[spring-task.xml](https://github.com/AndyHooo/master/blob/master/src/main/resources/spring-task.xml)