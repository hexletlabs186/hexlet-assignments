package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> childTags;

    public PairedTag(String name,  Map<String, String> params, String body, List<Tag> childTags) {
        this.name = name;
        this.body = body;
        this.params = params;
        this.childTags = childTags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<" + this.name);
        this.params.forEach((k,v) -> {
            sb.append(" " + k + "=\"" + v + "\"");
        });
        sb.append(">");

        if (!body.isEmpty()) sb.append(body);

        childTags.forEach(c -> {
            sb.append(c.toString());
        });

        sb.append("</" + this.name + ">");
        return sb.toString();
    }
}
// END
