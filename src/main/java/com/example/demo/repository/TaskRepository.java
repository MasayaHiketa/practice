package com.example.demo.repository;
import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long>{
    Optional<Task> findByTaskName(String taskName);
}