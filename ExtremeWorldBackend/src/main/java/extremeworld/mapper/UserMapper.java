package extremeworld.mapper;

import extremeworld.domain.User;
import extremeworld.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToDto(User user);

    User mapToEntity(UserDTO user);

}
