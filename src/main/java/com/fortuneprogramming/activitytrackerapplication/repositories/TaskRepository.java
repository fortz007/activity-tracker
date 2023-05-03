package com.fortuneprogramming.activitytrackerapplication.repositories;

import com.fortuneprogramming.activitytrackerapplication.entities.Task;
import com.fortuneprogramming.activitytrackerapplication.entities.User;
import com.fortuneprogramming.activitytrackerapplication.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUser(User user);
    Task findTaskByUserAndId(User user, Long taskId);
    List<Task> findTasksByUserAndStatus(User user, Status status);
}
