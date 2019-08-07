package com.example.kang.entity;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
public class Member {

    @Id
    private Long id;

    @Column
    private String name;
}
