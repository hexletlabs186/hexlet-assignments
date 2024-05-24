package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        storage.get("key", "default"); // "default"
        storage.get("value", "default"); // "key"

        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    }

    public static void swapKeyValue(KeyValueStorage storage) {
        var swapedMap = new HashMap<String, String>();

        storage.toMap().forEach((k,v) -> {
            swapedMap.put(v, k);
        });

        storage.toMap().clear();
        swapedMap.forEach((k,v) -> storage.set(k,v));
    }
}
// BEGIN

// END
