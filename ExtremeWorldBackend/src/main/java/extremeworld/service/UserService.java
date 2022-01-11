package extremeworld.service;

import extremeworld.domain.User;
import extremeworld.domain.UserType;
import extremeworld.dto.UserDTO;
import extremeworld.mapper.UserMapper;
import extremeworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
                    user.setUsername(newUser.getUsername());
                    user.setUserType(newUser.getUserType());
                    return userMapper.mapToDto(userRepository.save(user));
                })
                .orElseGet(() -> userMapper.mapToDto(userRepository.save(newUser)));
    }

    public UserDTO getUserByUsername(String username) {
        return userMapper.mapToDto(userRepository.findByUsername(username));
    }

    @Transactional
    public int loginUser(String username, String password) {
        List<User> existingUsers = userRepository.checkExistingUser(username, password);
        if(!existingUsers.isEmpty()) {
            userRepository.loginUser(username, password);
            return 1;
        }

        return -1;
    }

    @Transactional
    public int logoutUser(String username) {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            userRepository.logoutUser(username);
            return 1;
        }

        return -1;
    }
}
