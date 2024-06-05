package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Student;
import co.essejacques.springschoolmanagement.data.projections.StudentProjection;
import co.essejacques.springschoolmanagement.services.interfaces.IStudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
@Tag(name = "Students", description = "Students API")
public class StudentController {

    private final IStudentService studentService;

    @PostMapping()
    public Student saveSession(Student student)  {
        return this.studentService.save(student);
    }

    @GetMapping()
    public Page<StudentProjection> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    )  {
        return this.studentService.getAll(PageRequest.of(page, size));
    }


    @GetMapping("/{id}")
    public Student getSessionById(@PathVariable Long id)  {
        return this.studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id)  {
        this.studentService.delete(id);
    }

}
