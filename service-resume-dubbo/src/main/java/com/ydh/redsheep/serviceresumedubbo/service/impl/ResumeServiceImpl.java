package com.ydh.redsheep.serviceresumedubbo.service.impl;

import com.ydh.redsheep.servicedubboapi.service.ResumeService;
import com.ydh.redsheep.serviceresumedubbo.mapper.ResumeMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public Long findDefaultResumeByUserId(Long userId) {
        return resumeMapper.selectByPrimaryKey(userId).getId();
    }
}
