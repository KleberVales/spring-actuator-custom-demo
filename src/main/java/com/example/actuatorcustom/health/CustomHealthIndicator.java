package com.example.actuatorcustom.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    private boolean serviceUp = true;

    @Override
    public Health health() {
        if (serviceUp) {
            return Health.up().withDetail("CustomService", "Running Smoothly").build();
        }
        return Health.down().withDetail("CustomService", "Service Unavailable").build();
    }

    public void setServiceUp(boolean serviceUp) {
        this.serviceUp = serviceUp;
    }
}
