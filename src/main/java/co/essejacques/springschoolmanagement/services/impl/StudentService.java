package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import co.essejacques.springschoolmanagement.data.projections.StudentWithClassRoomProjection;
import co.essejacques.springschoolmanagement.data.repository.StudentRepository;
import co.essejacques.springschoolmanagement.services.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * @param pageRequest
     * @return
     */
    @Override
    public Page<StudentProjection> getAll(PageRequest pageRequest) {
        return studentRepository.findPagedProjectedBy(pageRequest);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
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
     * @param student
     * @return
     */
    @Override
    public Student update(Long id, Student student) {
        return studentRepository.save(student);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<StudentWithClassRoomProjection> findUserProjectedByEmail(String username) {
        return studentRepository.findStudentProjectedByEmail(username);
    }
}
