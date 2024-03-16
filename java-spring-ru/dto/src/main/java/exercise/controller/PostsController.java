package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index() {
        var postList = postRepository.findAll();
        postList.forEach(p -> p.setComments(commentRepository.findByPostId(p.getId())));

        return postList.stream().map(p -> mapPostToPostDTO(p)).toList();
    }

    @GetMapping("/{id}") // Вывод страницы
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable long id) {
         Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post with id " + id + " not found"));

         post.setComments(commentRepository.findByPostId(post.getId()));

        return mapPostToPostDTO(post);
    }

    public PostDTO mapPostToPostDTO (Post post) {
        var postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());

        //if (commentList.isEmpty())
         // хочу пройтись по списку и создать на основе его другой список
        var commentsDTO = post.getComments().stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setPostId(comment.getPostId());
            commentDTO.setBody(comment.getBody());
            return  commentDTO;
        }).toList();

        postDTO.setComments(commentsDTO);

        return postDTO;
    }
}
// END
