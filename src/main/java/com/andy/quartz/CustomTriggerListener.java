package com.andy.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerKey;
import org.quartz.TriggerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andy.domain.QrtzMisfiredTriggers;
import com.andy.mapper.QrtzMisfiredTriggersMapper;

/**
 * @ClassName CustomTriggerListener
 * @Description 添加trigger监听
 * @author hudaqiang
 * @Date 2018年1月28日 下午3:34:52
 */
@Component("customTriggerListener")
public class CustomTriggerListener implements TriggerListener {

	private static final Integer NOTIFIED = 1;
	private static final Integer NOT_NOTIFIED = 0;
	
	@Autowired
	private JobDetailBean jobDetailBean;
	
	@Autowired
	private QrtzMisfiredTriggersMapper qrtzMisfiredTriggersMapper;
	
	@Override
	public String getName() {
		return "CustomTriggerListener";
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {

	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		
		String targetObject = jobDetailBean.getTargetObject();
		String targetMethod = jobDetailBean.getTargetMethod();
		TriggerKey triggerKey = trigger.getKey();
		String triggerName = triggerKey.getName();
		Long shouldFiredTime = trigger.getStartTime().getTime();
		
		QrtzMisfiredTriggers qmt = new QrtzMisfiredTriggers();
		qmt.setTriggerName(triggerName);
		qmt.setTargetObject(targetObject);
		qmt.setTargetMethod(targetMethod);
		qmt.setShouldFiredTime(shouldFiredTime);
		qmt.setHasNotified(NOT_NOTIFIED);
		qmt.setInsertTime(new Date().getTime());
		
		qrtzMisfiredTriggersMapper.insert(qmt);
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
	}

}
