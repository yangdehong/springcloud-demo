package com.ydh.redsheep.serviceresumenacos.service.impl;

import com.ydh.redsheep.serviceresumenacos.mapper.ResumeMapper;
import com.ydh.redsheep.serviceresumenacos.pojo.Resume;
import com.ydh.redsheep.serviceresumenacos.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public Resume findDefaultResumeByUserId(Long userId) {
        return resumeMapper.selectByPrimaryKey(userId);
    }
}
