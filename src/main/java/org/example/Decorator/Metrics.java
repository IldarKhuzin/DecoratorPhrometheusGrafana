package org.example.Decorator;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class Metrics {
    static final Counter transformationCounter = Counter.build()
            .name("decorator_transformations_total")
            .help("Total number of string transformations")
            .register();

    public static void incrementTransformations() {
        transformationCounter.inc();
    }

    // запуск HTTP-сервера
    public static void startServer() throws IOException {
        HTTPServer server = new HTTPServer(8080); // метрики доступны на :8080/metrics
    }
}
