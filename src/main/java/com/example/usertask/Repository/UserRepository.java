package com.example.usertask.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import com.example.usertask.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    adding custum query

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.lastname = :lastname")
    List<User> findByNameAndLastname(@Param("name") String name, @Param("lastname") String lastname);

}
