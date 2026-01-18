package com.example.demo.dto;

import com.example.demo.entity.Task;

public class TaskResponse{
    private Long id;
    private String taskName;
    private String status;

    public TaskResponse(Long id, String taskName, String status){
        this.id = id;
        this.taskName = taskName;
        this.status = status;
    }

    //Entity to dto
    public static TaskResponse from(Task task){
        return new TaskResponse(
            task.getId(),
            task.getTaskName(),
            task.getStatus()
        );
    }

    public Long getId(){
        return id;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getStatus(){
        return status;
    }

}