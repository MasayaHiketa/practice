package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskUpdateRequest{
    
    @NotBlank
    private String taskName;
    
    @NotBlank
    private String status;

    public String getTaskName(){
        return taskName;
    }

    public String getStatus(){
        return status;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setStatus(String status){
        this.status = status;
    }

}