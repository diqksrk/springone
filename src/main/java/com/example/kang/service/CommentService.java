package com.example.kang.service;

import com.example.kang.entity.Comment;
import com.example.kang.exception.BusinessException;
import com.example.kang.exception.ErrorCode;
import com.example.kang.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> selectCommentList() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }

    public Comment insertComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment updateComment(Comment comment) {
        Optional<Comment> c = commentRepository.findById(comment.getId());
        log.info(c.get().getContent());
        return c.map(
                x -> {
                    x.setContent(comment.getContent());
                    return commentRepository.save(x);
                }
        ).orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }
}
