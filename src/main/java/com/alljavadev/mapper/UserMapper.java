package com.alljavadev.mapper;
import com.alljavadev.dto.UserDTO;
import com.alljavadev.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    //convert to entity from DTO
    public User convertToEntity(UserDTO dto){
        return mapper.map(dto, User.class);
    }

    //convert from entity to DTO

    public UserDTO convertToDTO(User user){
        return mapper.map(user, UserDTO.class);
    }
}
