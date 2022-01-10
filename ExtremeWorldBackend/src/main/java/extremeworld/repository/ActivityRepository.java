package extremeworld.repository;

import extremeworld.domain.Activity;
import extremeworld.domain.Resort;
import extremeworld.dto.ActivityDTO;
import extremeworld.exceptions.ActivityNotFoundException;
import extremeworld.exceptions.ResortNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
public class ActivityRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Activity save(Activity activity) {
        String saveActivitySql = "INSERT INTO activities (activity_name) VALUES (?)";
        jdbcTemplate.update(saveActivitySql, activity.getActivityName());

        Activity savedActivity = getActivityByName(activity.getActivityName());

        return savedActivity;
    }

    public Activity getActivityByName(String name) {
        String selectSql = "SELECT * FROM activities WHERE activity_name = ?";

        RowMapper<Activity> rowMapper = (resultSet, rowNo) -> Activity.builder()
                .id(resultSet.getLong("id"))
                .activityName(resultSet.getString("activity_name"))
                .build();

        List<Activity> activityList = jdbcTemplate.query(selectSql, rowMapper, name);

        if(!activityList.isEmpty()) {
            return activityList.get(0);
        }

        throw new ActivityNotFoundException("Activity not found!");
    }

    public Activity getActivityById(Long id) {

        String selectSql = "SELECT * FROM activities WHERE id = ?";

        RowMapper<Activity> rowMapper = (resultSet, rowNo) -> Activity.builder()
                .id(resultSet.getLong("id"))
                .activityName(resultSet.getString("activity_name"))
                .build();

        List<Activity> activityList = jdbcTemplate.query(selectSql, rowMapper, id);

        if(!activityList.isEmpty()) {
            return activityList.get(0);
        }

            throw new ActivityNotFoundException("Activity not found!");
    }

    public Activity addActivityToResort(Long id, Activity activity) {

        Activity savedActivity = save(activity);
        String saveResortActivitySql = "INSERT INTO resort_activity_junction (resort_id, activity_id) VALUES (?, ?)";

        jdbcTemplate.update(saveResortActivitySql, id, savedActivity.getId());

        return savedActivity;
    }
}
