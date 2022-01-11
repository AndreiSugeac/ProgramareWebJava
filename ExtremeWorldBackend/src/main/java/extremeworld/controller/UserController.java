package extremeworld.controller;

import extremeworld.domain.UserType;
import extremeworld.dto.UserDTO;
import extremeworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register/client")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .body(userService.createUser(userDTO, UserType.CLIENT));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<UserDTO> registerAdmin(@RequestBody UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .body(userService.createUser(userDTO, UserType.ADMIN));
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
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .body(userService.updateUser(userDTO, id));
    }

    @PatchMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        if(userService.loginUser(username, password) == 1) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "Login successful!";
        }
        else {
            response.setStatus(404);
            return "Invalid username or password!";
        }
    }

    @PatchMapping("/logout")
    public String logoutUser(@RequestParam String username, HttpServletResponse response) {
        if(userService.logoutUser(username) == 1) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "Logout successful!";
        }
        else {
            response.setStatus(404);
            return "Invalid username!";
        }
    }
}
