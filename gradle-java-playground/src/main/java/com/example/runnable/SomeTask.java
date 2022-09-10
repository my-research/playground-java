package com.example.runnable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeTask implements Runnable {

    private final int number;

    @Override
    public void run() {
        while(true) {
            System.out.println("this is task " + number + "'s " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }

    }
}
