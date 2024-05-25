package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.services.interfaces.IStudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
@Tag(name = "Students", description = "Students API")
public class StudentController {

    private final IStudentService studentService;

    @PostMapping()
    public Student saveSeance(Student student)  {
        return this.studentService.save(student);
    }

    @GetMapping()
    public List<Student> getStudents()  {
        return this.studentService.getAll();
    }


    @GetMapping("/{id}")
    public Student getSeanceById(@PathVariable Long id)  {
        return this.studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id)  {
        this.studentService.delete(id);
    }

}
