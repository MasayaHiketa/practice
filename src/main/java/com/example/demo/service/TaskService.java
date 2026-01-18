package com.example.demo.service;

import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Task;
import java.util.List;


@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    //Create
    public Task create(String taskName){
        Task task = new Task();
        task.setTaskName(taskName);
        task.setStatus("PENDING");
        return taskRepository.save(task);
    }
    //Read all
    @Transactional(readOnly = true)
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //Read (by id)
    @Transactional(readOnly = true)
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Task not found by this id"));
    }

    //Read (by taskName)
    @Transactional(readOnly = true)
    public Task getByTaskName(String taskName){
        return taskRepository.findByTaskName(taskName)
            .orElseThrow(() -> new IllegalArgumentException("Task not found by this name"));
    }

    //Update
    public Task updateTaskById(Long id, TaskUpdateRequest request){
        Task task = getTaskById(id);
        task.setTaskName(request.getTaskName());
        task.setStatus(request.getStatus());
        return taskRepository.save(task);
    }

    //Delete
    public void delete(Long id){
        Task task =taskRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Task not found cannot delete"));
        taskRepository.delete(task);
    }
    
}
