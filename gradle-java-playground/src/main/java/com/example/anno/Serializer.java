package com.example.anno;

import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    private final Gson gson = new Gson();

    public byte[] serialize(Object object) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(object);
                // serializedMember -> 직렬화된 member 객체
                return baos.toByteArray();
            }
        }
    }

    public Order2 deserialize(byte[] serialized) throws Exception {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serialized)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 역직렬화된 Member 객체를 읽어온다.
                Object objectMember = ois.readObject();
                return (Order2) objectMember;
            }
        }
    }
}
