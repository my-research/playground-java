package com.example;

public class LogAlerter {
    private final FileLoader loader;
    private final Notifier notifier;

    public LogAlerter(FileLoader loader, Notifier notifier) {
        this.loader = loader;
        this.notifier = notifier;
    }

    public void alert() {
        File file = loader.load("2022-12-12.log");

        String line = file.readFirstLine();
        String header = line.substring(0, 10);

        if (!header.equals("HEALTHY")) {
            return;
        }
        notifier.doNotify(line);
    }
}
