package com.fortuneprogramming.activitytrackerapplication.controllers;

import com.fortuneprogramming.activitytrackerapplication.dtos.taskdto.CreateTaskDto;
import com.fortuneprogramming.activitytrackerapplication.entities.Task;
import com.fortuneprogramming.activitytrackerapplication.enums.Status;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotFoundException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotNullException;
import com.fortuneprogramming.activitytrackerapplication.services.TaskService;
import com.fortuneprogramming.activitytrackerapplication.utils.ApiResponse;
import com.fortuneprogramming.activitytrackerapplication.utils.ResponseManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activity-tracker")
public class TaskController {
    private final TaskService taskService;
    private final ResponseManager responseManager;

    @PostMapping("/create-task")
    public ResponseEntity<ApiResponse<Task>> createTask(@RequestBody CreateTaskDto createTaskDto) throws NotNullException {
        ApiResponse<Task> task= taskService.createTask(createTaskDto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/my-tasks")
    public ResponseEntity<ApiResponse<List<Task>>> getLoggedInUserTasks(){
        ApiResponse<List<Task>> userTasks = taskService.getAllUserTasks();
        return new ResponseEntity<>(userTasks, HttpStatus.FOUND);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable Long taskId) throws NotFoundException {
        ApiResponse<Task> task = taskService.viewTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
    }

    @GetMapping("/my-tasks/{status}")
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByStatus(@PathVariable("status") Status status) throws NotFoundException {
        ApiResponse<List<Task>> taskServiceTaskByStatus = taskService.getTaskByStatus(status);
        return new ResponseEntity<>(taskServiceTaskByStatus, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-task-title-description/{taskId}")
    public ResponseEntity<ApiResponse<Task>> updateTaskTitleDescription(@PathVariable Long taskId, @RequestBody Task newTask) throws NotFoundException {
        ApiResponse<Task> updatedTask = taskService.updateTaskTitleOrDescription(taskId, newTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-task-status/{taskId}")
    public ResponseEntity<ApiResponse<Task>> updateTaskStatus(@PathVariable Long taskId, @RequestBody Task newTask){
        ApiResponse<Task> updatedTask = taskService.updateTaskStatus(taskId, newTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-task/{taskId}")
    public ResponseEntity<ApiResponse<String>> deleteTaskById(@PathVariable Long taskId){
        Task task = taskService.getTaskById(taskId);
        taskService.deleteTask(taskId);

        ApiResponse apiResponse = responseManager.success(task.getTitle().substring(0,1).toUpperCase() + task.getTitle().substring(1) + " deleted successfully");
        return new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
    }


}
