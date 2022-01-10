package extremeworld.repository;

import extremeworld.domain.Location;
import extremeworld.exceptions.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Location save(Location location) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String saveLocationSQL = "INSERT INTO locations (country, city, postal_code) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(saveLocationSQL, new String[] {"id"});
                        preparedStatement.setString(1, location.getCountry());
                        preparedStatement.setString(2, location.getCity());
                        preparedStatement.setString(3, location.getPostalCode());
                        return preparedStatement;
                    }
                }, keyHolder);
        Location savedLocation = getLocationById(keyHolder.getKey().longValue());
        return savedLocation;
    }

    public Location getLocationById(Long id) {
        String selectSql = "SELECT * FROM locations WHERE locations.id = ?";

        RowMapper<Location> rowMapper = (resultSet, rowNo) -> Location.builder()
                .id(resultSet.getLong("id"))
                .country(resultSet.getString("country"))
                .city(resultSet.getString("city"))
                .postalCode(resultSet.getString("postal_code"))
                .build();

        List<Location> locationList = jdbcTemplate.query(selectSql, rowMapper, id);

        if(!locationList.isEmpty()) {
            return locationList.get(0);
        }

        throw new LocationNotFoundException("Location not found!");
    }
}
