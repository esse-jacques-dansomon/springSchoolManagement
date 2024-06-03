package co.essejacques.springschoolmanagement.data.projections;


import java.util.Set;

public interface ClassRoomDetailsProjection {
    Long getId();
    String getName();
    String getDivision();
    String getLevel();
    Set<CourseProjection> getCourses();
}
