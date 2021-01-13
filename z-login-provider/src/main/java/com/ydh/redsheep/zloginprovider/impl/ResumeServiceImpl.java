package com.ydh.redsheep.zloginprovider.impl;

import com.ydh.redsheep.servicedubboapi.service.ResumeService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class ResumeServiceImpl implements ResumeService {

    @Override
    public Long findDefaultResumeByUserId(Long userId) {
        return 999L;
    }

}
