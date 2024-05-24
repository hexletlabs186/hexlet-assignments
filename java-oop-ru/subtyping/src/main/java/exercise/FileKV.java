package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV extends  AbstractKeyValueStorage {
    private Path filePath;

    public FileKV(Path filepath) {
        this.filePath = filepath;
        load();

    }

    private void load() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String content = Files.readString(this.filePath);

            Map<String, String> map = mapper.readValue(content, HashMap.class);
            this.kv.putAll(map);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private void save() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String content = mapper.writeValueAsString(this.kv);
            Files.writeString(filePath, content);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void set(String key, String value) {
        super.set(key, value);
        save();
    }

    @Override
    public void unset(String key) {
        super.unset(key);
        save();
    }
}

// END
