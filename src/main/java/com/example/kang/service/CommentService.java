package com.example.kang.service;

import com.example.kang.entity.Comment;
import com.example.kang.exception.BusinessException;
import com.example.kang.exception.ErrorCode;
import com.example.kang.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletionException;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> selectCommentList() {

        List<Comment> commentList=commentRepository.findAll();
        for (Comment c : commentList){
            log.info("=========================================");
            log.info(c.toString()+" "+c.getBoard().toString());
            log.info("=========================================");
        }

        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }
}
