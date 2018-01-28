package com.andy.mapper;

import com.andy.domain.QrtzMisfiredTriggers;

public interface QrtzMisfiredTriggersMapper {
    int insert(QrtzMisfiredTriggers record);

    int insertSelective(QrtzMisfiredTriggers record);
}