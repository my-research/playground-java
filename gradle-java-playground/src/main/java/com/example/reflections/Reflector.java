package com.example.reflections;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Reflector {
    public Object get() {
        Engine engine = new Engine("v8");
        return new Car(engine);
    }

    public Object getMethod() throws Exception {
        Engine engine = new Engine("v8");
        Car car = new Car(engine);
        return car.getClass().getMethod("describe", String.class);
    }
}
