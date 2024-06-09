package co.essejacques.springschoolmanagement.data.projections;


import java.util.Set;

public interface ClassRoomDetailsProjection extends ClassRoomProjection{
    Set<CourseProjection> getCourses();
}
