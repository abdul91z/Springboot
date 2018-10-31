package nl.han.dea.abdul.springboottwo.datasource;

import nl.han.dea.abdul.springboottwo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from users where user = ?1", nativeQuery=true)
    UserEntity findUserByUserName(String userName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET token= ?2 where user = ?1", nativeQuery = true)
    int setNewToken(String userName, String token);
}

