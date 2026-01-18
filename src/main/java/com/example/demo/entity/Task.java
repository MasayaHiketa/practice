package com.example.demo.entity;

import jakarta.persistence.*;      // Entity, Table, Id, Column, GeneratedValue
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name= "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name",columnDefinition = "text")
    private String taskName;

    @Column(nullable = false)
    private String status;


}

