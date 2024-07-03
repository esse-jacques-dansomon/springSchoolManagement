package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.Attendance;
import co.essejacques.springschoolmanagement.data.projections.AttendanceDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>, JpaSpecificationExecutor<Attendance> {
    List<AttendanceDetailsProjection> findBySessionId(Long sessionId);

    List<AttendanceDetailsProjection> findByStudentId(Long sessionStudentId);

    List<AttendanceDetailsProjection> findAllBySession_Course_Id(Long sessionCourseId);

    Optional<AttendanceDetailsProjection> findProjectedById(Long sessionSessionId);

    Page<AttendanceDetailsProjection> findPagedProjectedBy(Pageable pageable);
}