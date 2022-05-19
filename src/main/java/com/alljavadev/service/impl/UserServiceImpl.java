package com.alljavadev.service.impl;

import com.alljavadev.dto.UserDTO;
import com.alljavadev.entity.User;
import com.alljavadev.mapper.UserMapper;
import com.alljavadev.repository.UserRepository;
import com.alljavadev.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional //for derived query, for native query @Modifying
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    public List<UserDTO> listAllUsers() {
        List<User> usersList= userRepository.findAll(Sort.by("firstName")); //returns entity

        //convert entity to dto - mapper
        return usersList.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return mapper.convertToDTO(user);
    }

    @Override
    public void save(UserDTO dto) {
        userRepository.save(mapper.convertToEntity(dto));
    }

    @Override
    public UserDTO update(UserDTO dto) {
        //find user
        User user = userRepository.findByUserName(dto.getUserName());
        //map updated user dto to entity
        User convertedUser=mapper.convertToEntity(dto);

        //set id to converted object
        convertedUser.setId(user.getId());

        //save updated user
        userRepository.save(convertedUser);

        return findByUserName(dto.getUserName());
    }

    @Override
    public void deleteByUserName(String username) {
    userRepository.deleteByUserName(username);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> users= userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return users.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }
}
