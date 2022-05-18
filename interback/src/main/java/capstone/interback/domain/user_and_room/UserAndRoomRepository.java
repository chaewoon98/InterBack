package capstone.interback.domain.user_and_room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAndRoomRepository extends JpaRepository<UserAndRoom, Long> {

//    @Query("SELECT u * FROM USER_AND_ROOM u where u.user_id = :user_id")
//    List<UserAndRoom> findAllRoomById(@Param("user_id") String user_id);
}
