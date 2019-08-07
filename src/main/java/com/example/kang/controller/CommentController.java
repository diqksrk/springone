package com.example.kang.controller;

import com.example.kang.dto.RequireCreateComment;
import com.example.kang.dto.RequireUpdateComment;
import com.example.kang.entity.Board;
import com.example.kang.entity.Comment;
import com.example.kang.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public ResponseEntity<List<Comment>> getCommentList() {
        List<Comment> comments = commentService.selectCommentList();
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getComment(id));
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body("successmessage!!");
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@Valid @RequestBody RequireCreateComment requireCreateComment) {
        Board board = Board.builder().id(requireCreateComment.getBoard_id()).build();
        Comment comment = Comment.builder().content(requireCreateComment.getContent())
                .board(board).build();
        return ResponseEntity.status(HttpStatus.OK).body(commentService.insertComment(comment));
    }

    @PutMapping("/comment")
    public ResponseEntity<Comment> updateComment(@Valid @RequestBody RequireUpdateComment requireUpdateComment) {
        Comment comment = Comment.builder().id(requireUpdateComment.getId()).content(requireUpdateComment.getContent()).build();
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateComment(comment));
    }
}
