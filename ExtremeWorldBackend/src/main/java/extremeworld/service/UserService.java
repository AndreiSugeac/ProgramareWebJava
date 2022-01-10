package extremeworld.service;

import extremeworld.domain.User;
import extremeworld.domain.UserType;
import extremeworld.dto.UserDTO;
import extremeworld.mapper.UserMapper;
import extremeworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO, UserType userType) {
        User user = userMapper.mapToEntity(userDTO);
        user.setUserType(userType);
        User savedUser = userRepository.save(user);

        return userMapper.mapToDto(savedUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.getById(id);

        return userMapper.mapToDto(user);
    }

    public UserDTO updateUser(UserDTO newUserDTO, Long id) {
        User newUser = userMapper.mapToEntity(newUserDTO);

        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setPassword(newUser.getPassword());
                    user.setUserType(newUser.getUserType());
                    return userMapper.mapToDto(userRepository.save(user));
                })
                .orElseGet(() -> userMapper.mapToDto(userRepository.save(newUser)));
    }
}
