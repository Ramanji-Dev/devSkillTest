package  com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.NewCommentDto;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

	private CommentService commentService;
	
	private CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Integer postId) {
        // Handles GET /posts/{postId}/comments
    	
		return (ResponseEntity<List<CommentDto>>) commentService.getCommentsForPost(postId);
    }

    @PostMapping
    public ResponseEntity<Void> addComment(@PathVariable Integer postId,
                                           @RequestBody NewCommentDto newCommentDto) {
        // Handles POST /posts/{postId}/comments
    	commentService.addComment(postId, newCommentDto);
		return null;
    }
}









