package extremeworld.controller;

import extremeworld.domain.UserType;
import extremeworld.dto.UserDTO;
import extremeworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/client")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .body(userService.createUser(userDTO, UserType.CLIENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateStudent(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .body(userService.updateUser(userDTO, id));
    }
}
