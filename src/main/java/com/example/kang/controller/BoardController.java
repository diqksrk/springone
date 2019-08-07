package com.example.kang.controller;

import com.example.kang.dto.RequireCreateBoard;
import com.example.kang.dto.RequireUpdateBoard;
import com.example.kang.entity.Board;
import com.example.kang.service.BoardService;
import com.example.kang.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boards = boardService.selectBoardList();
        return ResponseEntity.status(HttpStatus.OK).body(boards);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoard(id));
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("successmessage!!");
    }

    @PostMapping("/board")
    public ResponseEntity<Board> createBoard(@Valid @RequestBody RequireCreateBoard requiredBoard) {
        Board board = Board.builder().title(requiredBoard.getTitle()).content(requiredBoard.getContent()).build();
        return ResponseEntity.status(HttpStatus.OK).body(boardService.insertBoard(board));
    }

    @PutMapping("/board")
    public ResponseEntity<Board> updateBoard(@Valid @RequestBody RequireUpdateBoard requireUpdateBoard) {
        Board board = Board.builder().id(requireUpdateBoard.getId()).title(requireUpdateBoard.
                getTitle()).content(requireUpdateBoard.getContent()).build();
        return ResponseEntity.status(HttpStatus.OK).body(boardService.updateBoard(board));
    }

}
