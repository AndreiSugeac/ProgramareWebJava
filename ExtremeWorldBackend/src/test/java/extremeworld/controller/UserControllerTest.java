package extremeworld.controller;

import Util.UserDtoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import extremeworld.dto.UserDTO;
import extremeworld.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("CreateUser_Test")
    void createUser() throws Exception {
        UserDTO userDTO = UserDtoUtil.generateUserDTO("Test", "User");
        when(userService.createUser(any(), any())).thenReturn(userDTO);

        MvcResult result = mockMvc.perform(post("/users/register/client")
                .content(objectMapper.writeValueAsString(userDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(userDTO));
    }

    @Test
    @DisplayName("Login_Test")
    void test_login() throws Exception {
        //Arrange
        String username = "ASugeac";
        String password = "Parola1";
        when(userService.loginUser(username, password)).thenReturn(1);

        //Act
        MvcResult result = mockMvc.perform(patch("/users/login?username=" + username + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo("Login successful!");
    }

    @Test
    @DisplayName("Login_Test")
    void test_login_Exception() throws Exception {
        //Arrange
        String username = "ASugeac";
        String password = "Parola1";
        when(userService.loginUser(username, password)).thenReturn(0);

        //Act
        MvcResult result = mockMvc.perform(patch("/users/login?username=" + username + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo("Invalid username or password!");
    }

    @Test
    @DisplayName("Test_Logout")
    void test_logout() throws Exception {
        //Arrange
        String username = "ASugeac";
        when(userService.logoutUser(username)).thenReturn(1);

        //Act
        MvcResult result = mockMvc.perform(patch("/users/logout?username=" + username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo("Logout successful!");
    }

    @Test
    void deleteOne() {

    }
}