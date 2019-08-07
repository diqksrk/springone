package com.example.kang.service;

import com.example.kang.entity.Board;
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
//        Comment comment = new Comment();
//        Board board = new Board();
//        comment.setBoard(board);

//        List<Comment> commentList=commentRepository.findAll();
//        List<Comment> comments = commentRepository.getAllByID(1L);
//        for (Comment c : comments){
//            log.info("=========================================");
//            log.info(c.getBoard().toString());
//            log.info("=========================================");
//        }

        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }
}
