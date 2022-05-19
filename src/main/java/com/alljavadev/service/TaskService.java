package com.alljavadev.service;

import com.alljavadev.dto.TaskDTO;
import com.alljavadev.dto.UserDTO;
import com.alljavadev.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

}
