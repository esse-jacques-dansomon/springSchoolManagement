package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.CourseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    List<Course> getCoursesByStatus(CourseStatus courseStatus);
    Course getCourseById(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course course);
    List<CourseProjection> getCoursesByClassRoom(Long id);
    List<CourseProjection> getCoursesByClassRoomAndStatus(Long id, CourseStatus status);
    Page<CourseProjection> getAll(PageRequest pageRequest);
}
