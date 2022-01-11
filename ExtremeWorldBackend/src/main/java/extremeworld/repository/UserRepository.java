package extremeworld.repository;

import extremeworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User SET logged_status = 1 where username = :username AND password = :password")
    void loginUser(String username, String password);

    @Modifying
    @Query("UPDATE User SET logged_status = 0 where username = :username")
    void logoutUser(String username);

    @Query("FROM User u WHERE u.username = :username AND u.password = :password")
    List<User> checkExistingUser(String username, String password);

    @Query("FROM User u WHERE u.username = :username")
    User findByUsername(String username);
}
