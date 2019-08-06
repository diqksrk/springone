package com.example.kang.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //테이블 많아졌을때 대비

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 400, nullable = false)
    private String content;

    @CreationTimestamp
    private LocalDateTime createDate;

}
