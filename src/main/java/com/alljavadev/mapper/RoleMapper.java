package com.alljavadev.mapper;

import com.alljavadev.dto.RoleDTO;
import com.alljavadev.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    private final ModelMapper mapper;


    public RoleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    //convert to entity from DTO
    public Role convertToEntity(RoleDTO dto){
        return mapper.map(dto, Role.class);
}

    //convert from entity to DTO

    public RoleDTO convertToDTO(Role role){
        return mapper.map(role, RoleDTO.class);
    }
}
