package com.alljavadev.service;

import com.alljavadev.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> listAllRoles();
   RoleDTO findById(Long id);
//    void save(RoleDTO dto);
//    RoleDTO update(RoleDTO dto);
//    void deleteByRole(String role);
}
