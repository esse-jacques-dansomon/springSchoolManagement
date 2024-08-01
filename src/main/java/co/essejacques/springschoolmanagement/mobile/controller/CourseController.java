package co.essejacques.springschoolmanagement.mobile.controller;


import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.CourseDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.CourseProjection;
import co.essejacques.springschoolmanagement.services.interfaces.ICourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/courses")
@RestController
@Tag(name = "Courses", description = "Courses API")
public class CourseController {

    private final ICourseService courseService;


    @PostMapping("")
    public Course saveCourse(Course course)  {
        return this.courseService.saveCourse(course);
    }

    @GetMapping
    public ResponseEntity<Page<CourseProjection>> getAttendances(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CourseProjection> courses = courseService.getAll(PageRequest.of(page, size));
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/status/{status}")
    public List<CourseDetailsProjection> getCoursesByStatus(@PathVariable CourseStatus status)  {
        return this.courseService.getCoursesByStatus(status);
    }

    @GetMapping("/classroom/{id}")
    public List<CourseProjection> getCoursesByClassRoomId(@PathVariable Long id)  {
        return this.courseService.getCoursesByClassRoom(id);
    }

    @GetMapping("/classroom/{id}/status/{status}")
    public List<CourseProjection> getCoursesByClassRoomId(@PathVariable Long id, @PathVariable CourseStatus status)   {
        return this.courseService.getCoursesByClassRoomAndStatus(id, status);
    }

    @GetMapping("/{id}")
    public CourseDetailsProjection getCourseById(@PathVariable Long id)  {
        return this.courseService.getCourseById(id);
    }


}
