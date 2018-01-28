package com.andy.domain;

public class QrtzMisfiredTriggers {
    private String targetObject;

    private String targetMethod;

    private String triggerName;

    private Long shouldFiredTime;

    private Integer hasNotified;

    private Long insertTime;

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject == null ? null : targetObject.trim();
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod == null ? null : targetMethod.trim();
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    public Long getShouldFiredTime() {
        return shouldFiredTime;
    }

    public void setShouldFiredTime(Long shouldFiredTime) {
        this.shouldFiredTime = shouldFiredTime;
    }

    public Integer getHasNotified() {
        return hasNotified;
    }

    public void setHasNotified(Integer hasNotified) {
        this.hasNotified = hasNotified;
    }

    public Long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }
}