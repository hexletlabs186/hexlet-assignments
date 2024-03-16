package exercise.dto;

import exercise.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// BEGIN
@Setter
@Getter
public class CommentDTO {
    private long id;

    private long postId;

    private String body;
}
// END
