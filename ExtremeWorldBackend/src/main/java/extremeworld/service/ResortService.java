package extremeworld.service;

import extremeworld.domain.Location;
import extremeworld.domain.Resort;
import extremeworld.dto.LocationDTO;
import extremeworld.dto.ResortDTO;
import extremeworld.mapper.LocationMapper;
import extremeworld.mapper.ResortMapper;
import extremeworld.repository.ResortsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResortService {

    @Autowired
    private ResortsRepository resortsRepository;

    @Autowired
    private ResortMapper resortMapper;

    @Autowired
    private LocationMapper locationMapper;

    public ResortDTO create(ResortDTO resortDTO) {
        Resort resort = resortMapper.mapToEntity(resortDTO);
        Location location = resort.getLocation();

        Resort savedResort = resortsRepository.save(resort, resort.getLocation());

        return resortMapper.mapToDto(savedResort);
    }

    public ResortDTO getResortById(Long id) {
        return resortMapper.mapToDto(resortsRepository.getResortById(id));
    }
}
