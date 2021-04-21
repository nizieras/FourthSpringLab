package com.example.demo.service;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Getter
@Service
public class CounterOfHandlings implements Runnable{

    private Logger logger = LoggerFactory.getLogger(CounterOfHandlings.class);
    private int handlings;

    public CounterOfHandlings(){
        handlings = 0;
    }

    synchronized public void addHandling()
    {
        handlings++;
        logger.info("Number of handlings: "+ handlings);
    }

    @Override
    public void run() {
        addHandling();
    }
}
