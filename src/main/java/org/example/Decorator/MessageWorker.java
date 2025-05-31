package org.example.Decorator;

public class MessageWorker implements Runnable {
    private final Message message;
    private final int intervalMillis;

    public MessageWorker(Message message, int intervalMillis) {
        this.message = message;
        this.intervalMillis = intervalMillis;
    }

    @Override
    public void run() {
        while (true) {
            String result = message.getMessage();
            System.out.println("Преобразованная строка: " + result);

            // Метрика будет тут (см. шаг 2)
            Metrics.incrementTransformations();

            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
