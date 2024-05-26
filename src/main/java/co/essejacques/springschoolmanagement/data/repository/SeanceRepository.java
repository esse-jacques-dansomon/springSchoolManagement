package co.essejacques.springschoolmanagement.data.repository;


import co.essejacques.springschoolmanagement.data.entity.Seance;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SeanceDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
  List<Seance> findAllByStatus(CourseStatus courseStatus);

  List<SeanceDetailsProjection> findAllByCourse_ClassRoom_IdAndDateIs(Long  course_classRoom_id, LocalDate endTime);

  List<SeanceDetailsProjection> findAllByCourse_ClassRoom_Id(Long id);
}