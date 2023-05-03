package com.fortuneprogramming.activitytrackerapplication.services;


import com.fortuneprogramming.activitytrackerapplication.dtos.taskdto.CreateTaskDto;
import com.fortuneprogramming.activitytrackerapplication.entities.Task;
import com.fortuneprogramming.activitytrackerapplication.entities.User;
import com.fortuneprogramming.activitytrackerapplication.enums.Status;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotFoundException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotNullException;
import com.fortuneprogramming.activitytrackerapplication.utils.ApiResponse;

import java.util.List;

public interface TaskService {
    User findLoggedInUser();

    Task getTaskById(Long taskId);

    ApiResponse<Task> createTask(CreateTaskDto createTaskDto) throws NotNullException;
    ApiResponse<List<Task>> getAllUserTasks();
    ApiResponse<Task> viewTaskById(Long taskId) throws NotFoundException;
    ApiResponse<List<Task>> getTaskByStatus(Status status) throws NotFoundException;

    ApiResponse<Task> updateTaskStatus(Long taskId, Task newTask);

    ApiResponse<Task> updateTaskTitleOrDescription(Long taskId, Task newTask) throws NotFoundException;
    void deleteTask(Long taskId);
}
