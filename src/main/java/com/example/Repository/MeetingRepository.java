package com.example.Repository;

import com.example.Entity.Meeting;
import com.example.Entity.Project;
import com.example.Entity.enums.MeetingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
    List<Meeting> findByProject(Project project);
    List<Meeting> findByType(MeetingType type);

    @Query("SELECT m FROM Meeting m WHERE m.project.id = :projectId AND m.scheduledDate BETWEEN :startDate AND :endDate")
    List<Meeting> findByProjectAndDateRange(@Param("projectId") UUID projectId,
                                            @Param("startDate") LocalDateTime startDate,
                                            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT m FROM Meeting m WHERE m.scheduledDate >= :currentDate ORDER BY m.scheduledDate ASC")
    List<Meeting> findUpcomingMeetings(@Param("currentDate") LocalDateTime currentDate);
}