package co.essejacques.springschoolmanagement.data.repository;


import co.essejacques.springschoolmanagement.data.entity.Seance;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
  List<Seance> findAllByStatus(CourseStatus courseStatus);
}