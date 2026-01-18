package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class TaskControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void createTask_ShouldReturnCreated() throws Exception{
        //1
        Task mockTask = new Task(1L,"Test Task","TODO");
        when(taskService.create(any())).thenReturn(mockTask);
        //2
        mockMvc.perform(post("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"taskName\":\"Test Task\"}"))
            .andExpect(status().isCreated());
    }
}