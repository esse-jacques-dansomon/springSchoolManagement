package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import co.essejacques.springschoolmanagement.data.projections.StudentWithClassRoomProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<StudentProjection> findPagedProjectedBy(Pageable pageable);
    Optional<StudentWithClassRoomProjection> findStudentProjectedByEmail(String username);
}