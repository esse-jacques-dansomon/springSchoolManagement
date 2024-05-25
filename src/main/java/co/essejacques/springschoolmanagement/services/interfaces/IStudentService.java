package co.essejacques.springschoolmanagement.services.interfaces;


import co.essejacques.springschoolmanagement.data.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student save(Student student);
    void delete(Long id);
    Student update(Long id, Student seance);
}
