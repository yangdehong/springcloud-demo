package com.ydh.redsheep.serviceresumenacos.service;

import com.ydh.redsheep.servicecommon.pojo.Resume;

public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
