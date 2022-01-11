package extremeworld.controller;

import Util.LocationDtoUtil;
import Util.ResortDtoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import extremeworld.domain.Location;
import extremeworld.dto.LocationDTO;
import extremeworld.dto.ResortDTO;
import extremeworld.service.LocationService;
import extremeworld.service.ResortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LocationController.class)
class LocationControllerTest {

    @MockBean
    private LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createLocation() throws Exception{
        LocationDTO dto = LocationDtoUtil.generateLocationDto("Madagascar");
        when(locationService.create(any())).thenReturn(dto);

        MvcResult result = mockMvc.perform(post("/locations/location")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(dto));
    }

    @Test
    void getLocationById() {
    }
}