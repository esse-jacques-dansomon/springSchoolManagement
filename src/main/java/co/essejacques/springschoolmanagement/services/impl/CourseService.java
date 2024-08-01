package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.CourseDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.CourseProjection;
import co.essejacques.springschoolmanagement.data.repository.CourseRepository;
import co.essejacques.springschoolmanagement.services.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService  implements ICourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseDetailsProjection> getAllCourses() {
        return courseRepository.findAllProjectedBy();
    }

    @Override
    public List<CourseDetailsProjection> getCoursesByStatus(CourseStatus courseStatus) {
        return this.courseRepository.findAllProjectedByStatus(courseStatus);
    }

    @Override
    public CourseDetailsProjection getCourseById(Long id) {
        return this
                .courseRepository
                .findProjectedById(id)
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
        return courseRepository.findDistinctByClassRoomId(id);
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

    /**
     * @param pageRequest
     * @return
     */
    @Override
    public Page<CourseProjection> getAll(PageRequest pageRequest) {
        return courseRepository.findPagedProjectedBy(pageRequest);
    }
}
