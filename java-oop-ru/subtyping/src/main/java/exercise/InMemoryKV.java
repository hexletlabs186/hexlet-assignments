package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV extends AbstractKeyValueStorage{
    public InMemoryKV(Map<String, String> map) {
        kv.putAll(map);
    }
}
// END
