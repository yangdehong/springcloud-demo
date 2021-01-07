package com.ydh.redsheep.serviceresume2.service.impl;

import com.ydh.redsheep.servicecommon.pojo.Resume;
import com.ydh.redsheep.serviceresume2.mapper.ResumeMapper;
import com.ydh.redsheep.serviceresume2.service.ResumeService;
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
