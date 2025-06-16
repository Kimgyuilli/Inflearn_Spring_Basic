package com.example.inflearn_spring_basic.web;

import com.example.inflearn_spring_basic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String testId) {
        myLogger.log("LogDemoService.logic(testId=" + testId + ") called");
    }
}
