package com.andy.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.andy.util.SendQQEmailUtil;

@Component
@EnableScheduling //spring 4中该注解必须加上,spring 3.x版本是不需要这个注解
public class QQMailJob {
	@Scheduled(cron = "0 30 22 * * ?")
	public void sendMail(){
		System.out.println("定时开始执行...");
		SendQQEmailUtil.sendEmail("报时提醒", "亲,现在是北京时间22:30");
	}
}
