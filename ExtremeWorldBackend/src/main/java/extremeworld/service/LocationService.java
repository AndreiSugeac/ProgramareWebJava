package extremeworld.service;

import extremeworld.domain.Location;
import extremeworld.dto.LocationDTO;
import extremeworld.mapper.LocationMapper;
import extremeworld.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private LocationMapper locationMapper;

    public LocationDTO create(LocationDTO locationDTO) {
        Location location = locationMapper.mapToEntity(locationDTO);
        Location savedLocation = locationsRepository.save(location);

        return locationMapper.mapToDto(savedLocation);
    }

    public LocationDTO getById(Long id) {
        Location location = locationsRepository.getLocationById(id);

        return locationMapper.mapToDto(location);
    }
}
