package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory;

import lombok.Getter;
import java.util.HashMap;

public class SessionStorageSingleton {

    @Getter
    private static final SessionStorageSingleton instance = new SessionStorageSingleton();

    private static final HashMap<String, Object> storage = new HashMap<>();

    private SessionStorageSingleton() {
    }

    public static Object get(String key) {
        return storage.get(key);
    }

    public static void set(String key, Object value) {
        storage.put(key, value);
    }
}
