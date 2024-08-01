package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.CourseDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.CourseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<CourseProjection> findPagedProjectedBy(Pageable pageable);

    List<CourseProjection> findDistinctByClassRoomId(Long id);

    List<CourseProjection> findAllByClassRoomIdAndStatus(Long id, CourseStatus status);

    List<CourseDetailsProjection> findAllProjectedBy();

    List<CourseDetailsProjection> findAllProjectedByStatus(CourseStatus courseStatus);

    Optional<CourseDetailsProjection> findProjectedById(Long id);
}