package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;

public class TaskCreateRequest {

    @NotBlank
    private String taskName;

    //getter/setter
    public String getTaskName(){
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    
}
