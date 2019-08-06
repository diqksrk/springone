package com.example.kang.service;


import com.example.kang.entity.Comment;
import com.example.kang.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor
@Log4j2
public class CommentServiceTest {

    private CommentRepository commentRepository;

//    @Test
//    public void getCommentTest(){
//        List<Comment> commentList = commentRepository.findAll();
//        log.info(commentList);
//    }
}
