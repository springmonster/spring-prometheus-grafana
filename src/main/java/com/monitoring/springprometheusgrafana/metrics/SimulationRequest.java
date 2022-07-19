package com.monitoring.springprometheusgrafana.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimulationRequest {
    private Integer count1 = 0;

    @Autowired
    private DemoMetrics demoMetrics;

    @Async("One")
    @Scheduled(fixedDelay = 1000)
    public void increment() {
        demoMetrics.counter.increment();

        count1++;
        demoMetrics.map.put("x", Double.valueOf(count1));
        System.out.println("increment1 count: " + count1);
    }
}
