package co.essejacques.springschoolmanagement.services.interfaces;


import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Page<StudentProjection> getAll(PageRequest pageRequest);
    Student getById(Long id);
    Student save(Student student);
    void delete(Long id);
    Student update(Long id, Student student);
}
