package extremeworld.mapper;

import extremeworld.domain.User;
import extremeworld.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToDto(User user);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "userType", source = "userType")
    User mapToEntity(UserDTO userDTO);

}
