package com.alljavadev.mapper;

import com.alljavadev.dto.ProjectDTO;
import com.alljavadev.dto.TaskDTO;
import com.alljavadev.entity.Project;
import com.alljavadev.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final ModelMapper mapper;

    public TaskMapper (ModelMapper mapper) {
        this.mapper = mapper;
    }

    //convert to entity from DTO
    public Task convertToEntity(TaskDTO dto){
        return mapper.map(dto, Task.class);
    }

    //convert from entity to DTO
    public TaskDTO convertToDTO(Task entity){
        return mapper.map(entity, TaskDTO.class);
    }
}
