package com.example.Repository;

import com.example.Entity.PeerEvaluation;
import com.example.Entity.Project;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PeerEvaluationRepository extends JpaRepository<PeerEvaluation, UUID> {


}
