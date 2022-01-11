package Util;

import extremeworld.dto.UserDTO;

public class UserDtoUtil {

    public static UserDTO generateUserDTO(String firstName, String lastName) {
        return UserDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .password("pass123")
                .username("userName")
                .build();
    }
}
