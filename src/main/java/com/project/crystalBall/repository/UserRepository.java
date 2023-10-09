package com.project.crystalball.repository;

import com.project.crystalball.entity.project.ProjectEntity;
import com.project.crystalball.entity.user.UserEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = "select * from user_details where name = :userName and password = :encodedPassword")
    Optional<UserEntity> findByUserNameAndPassword(@Param("userName") String userName, @Param("encodedPassword") String password);


    @Query(nativeQuery = true, value = "select * from user_details where name = :userName")
    Optional<UserEntity> findByUserName(@Param("userName") String userName);
}
