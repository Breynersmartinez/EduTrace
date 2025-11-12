package com.example.Repository;

import com.example.Entity.GitContribution;
import com.example.Entity.Project;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface GitContributionRepository extends JpaRepository<GitContribution, UUID> {

   }