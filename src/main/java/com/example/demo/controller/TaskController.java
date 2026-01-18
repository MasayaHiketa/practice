package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.dto.TaskCreateRequest;
import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.dto.TaskResponse;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Task;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService  = taskService;
    }

    //Create new task
    @PostMapping
    public ResponseEntity<TaskResponse> create(
        @RequestBody @Valid TaskCreateRequest request
    ){
        Task task = taskService.create(request.getTaskName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TaskResponse.from(task));
    }

    //Get all tasks
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        List<TaskResponse> responses = taskService.getAllTasks()
            .stream()
            .map(TaskResponse::from)
            .toList();
        return ResponseEntity.ok(responses);
    }

    //Get 1 task by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(TaskResponse.from(task));
    }

    //Update by id
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTaskById(
        @RequestBody @Valid TaskUpdateRequest request,
        @PathVariable Long id
    ){
        Task updated =  taskService.updateTaskById(id,request);
        return ResponseEntity.ok(TaskResponse.from(updated));
    }

    //Delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
