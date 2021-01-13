package com.ydh.redsheep.serviceresumenacos2.service;

import com.ydh.redsheep.servicecommon.pojo.Resume;

public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
