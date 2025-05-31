package org.example.Decorator;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.core.instrument.MeterRegistry;

public class MetricsRegistry {
    public static final PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

    public static MeterRegistry getRegistry() {
        return registry;
    }
}
