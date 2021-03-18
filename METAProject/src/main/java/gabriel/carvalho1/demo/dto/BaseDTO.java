package gabriel.carvalho1.demo.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public static String toJson(Object o) throws IOException {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (IOException e) {
            throw new IOException("Fail to convert Object to json");
        }
    }

    static Object fromJson(String json, Class<?> classe) throws IOException {
        try {
            return new ObjectMapper().readValue(json, classe);
        } catch (IOException e) {
            throw new IOException(String.format("Fail to convert %s from json", classe.getName()));
        }
    }
}


