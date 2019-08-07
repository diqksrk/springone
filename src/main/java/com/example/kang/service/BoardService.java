package com.example.kang.service;

import com.example.kang.entity.Board;
import com.example.kang.entity.Comment;
import com.example.kang.exception.BusinessException;
import com.example.kang.exception.ErrorCode;
import com.example.kang.repository.BoardRepository;
import com.example.kang.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService { //프로젝트 난이도가 커지면 임플리먼트 사용. 크지 않으면 쓸 필요가?

    private final BoardRepository boardRepository;
    private final CommentService commentService;

    @Transactional
    public Board getBoard(Long id) {
//        Comment comment = commentService.getComment(1L);
//        List<Comment> commentList = new ArrayList<>();
//        commentList.add(comment);
//        board.setCommentList(commentList);

        return boardRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }

    public List<Board> selectBoardList() {
        return boardRepository.findAll();
    }

    public Board insertBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public Board updateBoard(Board board) {
        Optional<Board> b = boardRepository.findById(board.getId());
        return b.map(
                x -> {
                    x.setTitle(board.getTitle());
                    x.setContent(board.getContent());
                    return boardRepository.save(x);
                }
        ).orElseThrow(() -> new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }
}
