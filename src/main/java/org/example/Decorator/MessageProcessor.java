package org.example.Decorator;

import io.micrometer.core.instrument.Counter;
import org.example.Decorator.MetricsRegistry;

public class MessageProcessor implements Runnable {
    private final Message message;
    private final long intervalMillis;
    private final Counter messageCounter;

    public MessageProcessor(Message message, long intervalMillis) {
        this.message = message;
        this.intervalMillis = intervalMillis;
        this.messageCounter = Counter.builder("processed_messages_total")
                .description("Количество обработанных сообщений")
                .register(MetricsRegistry.getRegistry());
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String result = message.getMessage();
            System.out.println("Processed message: " + result);
            messageCounter.increment();

            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                break;
            }
        }
    }
}
