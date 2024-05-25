package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s.id AS id, s.email AS email, s.first_name AS first_name, s.last_name AS last_name, s.address AS address, s.registration_number AS registration_number FROM users s",
            countQuery = "SELECT COUNT(s) FROM users s",
            nativeQuery = true)
    Page<StudentProjection> getPaginateStudents(Pageable pageable);
}