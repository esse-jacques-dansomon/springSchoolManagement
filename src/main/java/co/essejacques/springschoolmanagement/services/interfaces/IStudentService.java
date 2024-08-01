package co.essejacques.springschoolmanagement.services.interfaces;


import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import co.essejacques.springschoolmanagement.data.projections.StudentWithClassRoomProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    Page<StudentProjection> getAll(PageRequest pageRequest);
    Student getById(Long id);
    Student save(Student student);
    void delete(Long id);
    Student update(Long id, Student student);
    Optional<StudentWithClassRoomProjection> findUserProjectedByEmail(String username);
}
