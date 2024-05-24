package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> params) {
      this.name = name;
      this.params = params;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<" + this.name);
        this.params.forEach((k,v) -> {
            sb.append(" " + k + "=\"" + v + "\"");
        });
        sb.append(">");
        return sb.toString();
    }
}
// END
