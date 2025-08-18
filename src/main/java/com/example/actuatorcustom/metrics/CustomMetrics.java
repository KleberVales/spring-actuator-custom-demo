package com.example.actuatorcustom.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;
    private int helloCounter = 0;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        meterRegistry.gauge("custom.hello.counter", this, CustomMetrics::getHelloCounter);
    }

    public void incrementHelloCounter() {
        helloCounter++;
    }

    public int getHelloCounter() {
        return helloCounter;
    }
}
