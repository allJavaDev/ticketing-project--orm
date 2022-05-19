package com.alljavadev.service.impl;

import com.alljavadev.dto.RoleDTO;
import com.alljavadev.entity.Role;
import com.alljavadev.mapper.RoleMapper;
import com.alljavadev.repository.RoleRepository;
import com.alljavadev.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RoleServiceImpl implements RoleService {


    //Injection
    private final RoleRepository roleRepository;
    private final RoleMapper mapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }


    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> listRole = roleRepository.findAll(); //returns entity

        //convert entity to dto - mapper
        return listRole.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        return mapper.convertToDTO(roleRepository.findById(id).get());
    }
}
