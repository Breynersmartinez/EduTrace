package com.example.Repository;

import com.example.Entity.User;
import com.example.Entity.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
/*
    Optional<User> findByEmail(String email);

    List<User> findByRole(UserRole role);

    List<User> findByIsActiveTrue();

    Optional<User> findByGithubUsername(String githubUsername);

    @Query("SELECT u FROM User u WHERE u.role = 'STUDENT' AND u.isActive = true")
    List<User> findActiveStudents();

    @Query("SELECT u FROM User u WHERE u.role = 'PROFESSOR' AND u.isActive = true")
    List<User> findActiveProfessors();

    @Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> findByNameContainingIgnoreCase(@Param("name") String name); */
}

