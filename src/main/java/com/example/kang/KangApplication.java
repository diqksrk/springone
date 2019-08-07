package com.example.kang;

import com.example.kang.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class KangApplication {

//    @PersistenceContext
//    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(KangApplication.class, args);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
//        System.out.println("hello");
//        Member member = new Member();
//        member.setId(100L);
//        member.setName("안녕하세요");

    }

}
