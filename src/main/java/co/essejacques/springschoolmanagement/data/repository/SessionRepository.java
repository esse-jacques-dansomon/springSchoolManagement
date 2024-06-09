package co.essejacques.springschoolmanagement.data.repository;


import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
  List<SessionDetailsProjection> findAllByStatus(CourseStatus courseStatus);
  List<SessionDetailsProjection> findAllByCourse_ClassRoom_IdAndDateIs(Long  course_classRoom_id, LocalDate endTime);
  List<SessionDetailsProjection> findAllByCourse_ClassRoom_Id(Long id);
  List<SessionDetailsProjection> findProjectedBy();
  Page<SessionDetailsProjection> findPagedProjectedBy(Pageable pageable);
}