package com.alljavadev.mapper;

import com.alljavadev.dto.ProjectDTO;
import com.alljavadev.dto.UserDTO;
import com.alljavadev.entity.Project;
import com.alljavadev.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class ProjectMapper {
    private final ModelMapper mapper;

    public ProjectMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    //convert to entity from DTO
    public Project convertToEntity(ProjectDTO dto){
        return mapper.map(dto, Project.class);
    }

    //convert from entity to DTO
    public ProjectDTO convertToDTO(Project entity){
        return mapper.map(entity, ProjectDTO.class);
    }
}







