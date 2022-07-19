package com.monitoring.springprometheusgrafana.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DemoMetrics implements MeterBinder {

    public Counter counter;
    public Map<String, Double> map = new HashMap<>();

    @Override
    public void bindTo(MeterRegistry registry) {
        // name is spg.demo.counter, tag is name:counter1
        this.counter = Counter.builder("prometheus.demo.counter").tags("name", "counter1").description("demo counter").register(registry);

        // name is spg.demo.gauge, tag is name:gauge1
        Gauge.builder("prometheus.demo.gauge", map, x -> x.get("x")).tags("name", "gauge1").description("demo gauge").register(registry);
    }
}
