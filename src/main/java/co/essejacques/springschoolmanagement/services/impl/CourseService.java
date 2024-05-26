package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.CourseProjection;
import co.essejacques.springschoolmanagement.data.repository.CourseRepository;
import co.essejacques.springschoolmanagement.services.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService  implements ICourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByStatus(CourseStatus courseStatus) {
        return this.courseRepository.findAllByStatus(courseStatus);
    }

    @Override
    public Course getCourseById(Long id) {
        return this
                .courseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course saveCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return this.courseRepository.save(course);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<CourseProjection> getCoursesByClassRoom(Long id) {
        return courseRepository.findByClassRoomId(id);
    }

    /**
     * @param id
     * @param status
     * @return
     */
    @Override
    public List<CourseProjection> getCoursesByClassRoomAndStatus(Long id, CourseStatus status) {
        return courseRepository.findAllByClassRoomIdAndStatus(id, status);
    }
}
