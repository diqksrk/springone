package com.example.kang.service;

import com.example.kang.entity.Board;
import com.example.kang.exception.BusinessException;
import com.example.kang.exception.ErrorCode;
import com.example.kang.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //프로젝트 난이도가 커지면 임플리먼트 사용. 크지 않으면 쓸 필요가?
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board getBoard(Long id) {
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
        ).orElseThrow(()->new BusinessException(ErrorCode.BOARD_NOT_EXIST));
    }

}
