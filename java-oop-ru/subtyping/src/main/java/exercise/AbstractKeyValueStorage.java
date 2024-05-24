package exercise;

import java.util.HashMap;
import java.util.Map;

public class AbstractKeyValueStorage implements  KeyValueStorage {

    protected HashMap<String,String> kv = new HashMap<>();

    @Override
    public void set(String key, String value) {
        kv.put(key, value);
    }

    @Override
    public void unset(String key) {
        kv.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return kv.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(kv);
    }
}
