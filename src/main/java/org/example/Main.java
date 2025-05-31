package org.example;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;
import org.example.Decorator.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Запускаем HTTP сервер на порту 9000
        HTTPServer server = new HTTPServer.Builder()
                .withPort(9000)
                .withRegistry(MetricsRegistry.registry.getPrometheusRegistry())
                .build();

        // Добавим метрики JVM
        DefaultExports.initialize();

        Message message = new ExString(
                new UpString(
                        new SimpleString("Привет, Ильдар")));

        Thread thread = new Thread(new MessageProcessor(message, 2000));
        thread.start();

//        Thread.sleep(100000);
//        thread.interrupt();
    }
}
