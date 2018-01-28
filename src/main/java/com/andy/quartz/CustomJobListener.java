package com.andy.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @ClassName CustomJobListener
 * @Description 添加job监听
 * @author hudaqiang
 * @Date 2018年1月28日 下午3:22:08
 */
public class CustomJobListener implements JobListener {

	@Override
	public String getName() {
		return "CustomJobListener";
	}

	/* (非 Javadoc)
	 * Description:
	 * @see org.quartz.JobListener#jobToBeExecuted(org.quartz.JobExecutionContext)
	 * Scheduler 在 JobDetail 将要被执行时调用这个方法。
	 */
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {

	}

	/* (非 Javadoc)
	 * Description:
	 * @see org.quartz.JobListener#jobExecutionVetoed(org.quartz.JobExecutionContext)
	 * Scheduler 在 JobDetail 即将被执行，但又被 TriggerListener 否决了时调用这个方法。
	 */
	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {

	}

	/* (非 Javadoc)
	 * Description:
	 * @see org.quartz.JobListener#jobWasExecuted(org.quartz.JobExecutionContext, org.quartz.JobExecutionException)
	 * Scheduler 在 JobDetail 被执行之后调用这个方法。 
	 */
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

	}

}
