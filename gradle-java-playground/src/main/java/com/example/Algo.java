package com.example;

public class Algo {
    public static void main(String[] args) {
        int n = 28;
        String[] split = String.valueOf(n).split("");

        for (int i = split.length - 1; i >= 0; i--) {
            int number = Integer.parseInt(split[i]);
            if (number != 0) {
                split[i] = split[i] + 1;

                int result = 0;

                for (int j = 0; j < split.length; j++) {
                    result = result * 10 + Integer.parseInt(split[j]);
                }
                System.out.println(result);
                return;
            }
        }
        System.out.println(n + (int)Math.pow(10, split.length));
    }
}
