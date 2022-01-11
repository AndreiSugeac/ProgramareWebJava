package extremeworld.controller;

import Util.ResortDtoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import extremeworld.dto.ResortDTO;
import extremeworld.service.ResortService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ResortController.class)
class ResortControllerTest {

    @MockBean
    private ResortService resortService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("CreateResort_Test")
    void createResort() throws Exception{
        ResortDTO dto = ResortDtoUtil.generateResortDTO("TestResort");
        when(resortService.create(any())).thenReturn(dto);

        MvcResult result = mockMvc.perform(post("/resorts/resort")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(dto));
    }

    @Test
    void getById() {

    }

    @Test
    void getByCity() {

    }
}