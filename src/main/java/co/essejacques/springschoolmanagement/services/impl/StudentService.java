package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.repository.StudentRepository;
import co.essejacques.springschoolmanagement.services.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    /**
     * @return
     */
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Seance not found"));
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * @param id
     * @param seance
     * @return
     */
    @Override
    public Student update(Long id, Student seance) {
        return studentRepository.save(seance);
    }
}