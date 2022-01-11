package extremeworld.mapper;

import extremeworld.domain.User;
import extremeworld.domain.User.UserBuilder;
import extremeworld.domain.UserType;
import extremeworld.dto.UserDTO;
import extremeworld.dto.UserDTO.UserDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-11T11:24:39+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.lastName( user.getLastName() );
        userDTO.firstName( user.getFirstName() );
        userDTO.password( user.getPassword() );
        userDTO.username( user.getUsername() );
        if ( user.getUserType() != null ) {
            userDTO.userType( user.getUserType().name() );
        }

        return userDTO.build();
    }

    @Override
    public User mapToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.username( userDTO.getUsername() );
        if ( userDTO.getUserType() != null ) {
            user.userType( Enum.valueOf( UserType.class, userDTO.getUserType() ) );
        }
        user.id( userDTO.getId() );
        user.firstName( userDTO.getFirstName() );
        user.lastName( userDTO.getLastName() );
        user.password( userDTO.getPassword() );

        return user.build();
    }
}
