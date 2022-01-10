package extremeworld.repository;

import extremeworld.domain.Activity;
import extremeworld.domain.Location;
import extremeworld.domain.Resort;
import extremeworld.exceptions.LocationNotFoundException;
import extremeworld.exceptions.ResortNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Null;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResortsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    EntityManager entityManager;

    public Resort save(Resort resort) {

        String saveResortSql = "INSERT INTO resorts (resort_name) VALUES (?)";
        jdbcTemplate.update(saveResortSql, resort.getResortName());

        Resort savedResort = getResortByName(resort.getResortName());

        return savedResort;
    }

    public Resort save(Resort resort, Location location) {

        Long locationId = locationsRepository.save(location).getId();

        String saveResortSql = "INSERT INTO resorts (resort_name, location_id) VALUES (?, ?)";
        //jdbcTemplate.update(saveResortSql, resort.getResortName(), locationId);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(saveResortSql, new String[] {"id"});
                        preparedStatement.setString(1, resort.getResortName());
                        preparedStatement.setLong(2, locationId);
                        return preparedStatement;
                    }
                }, keyHolder);

        Resort savedResort = getResortById(keyHolder.getKey().longValue());

        return savedResort;
    }

    public Resort save(Resort resort, Location location, Activity activity) {

        Long locationId = locationsRepository.save(location).getId();

        Long activityId = activityRepository.save(activity).getId();

        String saveResortSql = "INSERT INTO resorts (resort_name, location_id) VALUES (?, ?)";
        //jdbcTemplate.update(saveResortSql, resort.getResortName(), locationId);

        String saveResortActivitySql = "INSERT INTO resort_activity_junction (resort_id, activity_id) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(saveResortSql, new String[] {"id"});
                        preparedStatement.setString(1, resort.getResortName());
                        preparedStatement.setLong(2, locationId);
                        return preparedStatement;
                    }
                }, keyHolder);

        Resort savedResort = getResortById(keyHolder.getKey().longValue());

        jdbcTemplate.update(saveResortActivitySql, savedResort.getId(), activityId);

        return savedResort;
    }

    public Resort getResortById(Long id) {
        String selectSql = "SELECT * FROM resorts r JOIN locations l ON r.location_id = l.id WHERE r.id = ?";

        RowMapper<Resort> rowMapper = (resultSet, rowNo) -> Resort.builder()
                .id(resultSet.getLong("id"))
                .resortName(resultSet.getString("resort_name"))
                .build();

        /*TypedQuery<Resort> query = entityManager.createQuery(selectSql, Resort.class);
        query.setParameter(1, id);

        List<Resort> resortList = query.getResultList();*/

        List<Resort> resortList = jdbcTemplate.query(selectSql, rowMapper, id);

        if(!resortList.isEmpty()) {
            return resortList.get(0);
        }

        throw new ResortNotFoundException("Resort not found!");
    }

    public Resort getResortByName(String name) {
        String selectSql = "SELECT * FROM resorts WHERE resort_name = ?";

        RowMapper<Resort> rowMapper = (resultSet, rowNo) -> Resort.builder()
                .id(resultSet.getLong("id"))
                .resortName(resultSet.getString("resort_name"))
                .build();

        List<Resort> resortList = jdbcTemplate.query(selectSql, rowMapper, name);

        if(!resortList.isEmpty()) {
            return resortList.get(0);
        }

        throw new ResortNotFoundException("Resort not found!");
    }

}
